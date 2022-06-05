package com.api.vitrine.config;

import com.api.vitrine.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService
            usuarioService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("eduarda")
                .password(passwordEncoder.encode("teste"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("andre")
                .password(passwordEncoder.encode("teste"))
                .roles("USER", "ADMIN");

        log.info(passwordEncoder.encode("teste"));
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST,"/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}

