package com.rmit.sept.bk_requests.requests.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.rmit.sept.bk_requests.requests.services.RequestService;


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