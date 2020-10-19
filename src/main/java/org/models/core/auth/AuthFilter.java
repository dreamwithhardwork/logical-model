package org.models.core.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import java.io.IOException;

@Component
class AuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException, ServletException {

        filterChain.doFilter(request,response);
        String requestTokenHeader = request.getHeader("Authorization");
    }
}
