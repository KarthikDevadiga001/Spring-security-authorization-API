package com.androidventures.UniMealServer.springboot.config;

import com.androidventures.UniMealServer.springboot.service.JWTservice;
import com.androidventures.UniMealServer.springboot.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    JWTservice jwtservice;
    @Autowired
    ApplicationContext context;
    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader =request.getHeader("Authorization");

        String token = null;
        String username = null;

        if(authHeader!=null&& authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            username=jwtservice.extractUserName(token);
        }

        if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails=context.getBean(MyUserDetailsService.class).loadUserByUsername(username);

//            MyUserDetailsService obj=context.getBean(MyUserDetailsService.class);
//            UserDetails userDetails=obj.loadUserByUsername(username);

            if(jwtservice.validateToken(token,userDetails)){

                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }

        }

        filterChain.doFilter(request,response);
    }
}
