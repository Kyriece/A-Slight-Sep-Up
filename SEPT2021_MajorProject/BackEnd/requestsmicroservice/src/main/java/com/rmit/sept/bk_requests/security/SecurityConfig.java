package com.rmit.sept.bk_requests.security;

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

import com.rmit.sept.bk_requests.*;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
RequestService requestService;



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
    .antMatchers("/api/requests/**").permitAll()
    .anyRequest().authenticated();
	}

    // @Bean
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    // // ALTHOUGH THIS SEEMS LIKE USELESS CODE,
    // // IT'S REQUIRED TO PREVENT SPRING BOOT AUTO-CONFIGURATION
    // return super.authenticationManagerBean();
// }

// @Bean
// CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration configuration = new CorsConfiguration();
//         configuration.setAllowedOrigins(Arrays.asList("*"));
//         configuration.setAllowedMethods(Arrays.asList("*"));
//         configuration.setAllowedHeaders(Arrays.asList("*"));
//         configuration.setAllowCredentials(true);
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", configuration);
//         return source;
//     }
    
}