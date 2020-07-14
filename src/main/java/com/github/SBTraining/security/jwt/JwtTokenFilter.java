package com.github.SBTraining.security.jwt;

import com.github.SBTraining.security.UserDetailsServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@Component
@Log
public class JwtTokenFilter extends GenericFilterBean {

    public static final String AUTHORIZATION="Authorization";

    private SecurityContext securityContext=SecurityContextHolder.getContext();

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        String userLogin = " ";
        JwtUser jwtUser = null;
        if(token!=null && jwtProvider!=null) {
            userLogin = jwtProvider.getUsernameFromToken(token);
            jwtUser = userDetailsService.loadUserByUsername(userLogin);
        }
        if (token != null && jwtUser!=null && jwtProvider.validateToken(token,jwtUser)) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
            securityContext.setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        logger.info(bearer);
        if (bearer != null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

}