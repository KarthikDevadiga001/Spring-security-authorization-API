package com.androidventures.UniMealServer.springboot.service;

import com.androidventures.UniMealServer.springboot.models.User;
import com.androidventures.UniMealServer.springboot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import static org.hibernate.cfg.JdbcSettings.USER;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user =repo.findByUsername(username);
            if(user==null)
            {
                System.out.println("User not found ");
                throw new UsernameNotFoundException("error 404");
            }

            UserDetails userdetails=new UserDetails() {

                GrantedAuthority auth=new SimpleGrantedAuthority("USER");
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return  Collections.singleton(auth);
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return username;
                }
            };

            UserDetails admindetails=new UserDetails() {

                GrantedAuthority auth=new SimpleGrantedAuthority("ADMIN");
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return  Collections.singleton(auth);
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return username;
                }
            };

            return userdetails;


    }
}
