package com.github.SBTraining.security.jwt;

import com.github.SBTraining.security.UserDetailsServiceImpl;
import com.github.SBTraining.security.entry_point.AuthEntryPoint;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
@Log
public class JwtTokenFilter extends GenericFilterBean {

    public static final String AUTHORIZATION="Authorization";

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userLogin = null;
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if(token!=null && jwtProvider!=null) {
            userLogin = jwtProvider.getUsernameFromToken(token);
        }
        if (userLogin != null) {
            JwtUser jwtUser = userDetailsService.loadUserByUsername(userLogin);
            if(jwtProvider.validateToken(token,jwtUser)) {
                logger.info(true);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        logger.info(bearer);
        if (bearer!=null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }


}