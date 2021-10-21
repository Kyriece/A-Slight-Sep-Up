package com.rmit.sept.bk_Listing.listingmicroservices.security;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.rmit.sept.bk_Listing.listingmicroservices.service.*;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


@Override
protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable()
	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .headers().frameOptions().sameOrigin().
    and().
	authorizeRequests().
    antMatchers(
                        "/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
    .antMatchers("/api/**").permitAll()
    .antMatchers("/api/listings/**").permitAll()
    .anyRequest().authenticated();
	}


    
}