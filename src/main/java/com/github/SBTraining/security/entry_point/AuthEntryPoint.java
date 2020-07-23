package com.github.SBTraining.security.entry_point;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Checking request contains token
        if(request.getHeader("Authorization")==null)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"You need token");
    }
}
