package com.github.SBTraining.security;


import com.github.SBTraining.security.jwt.JwtConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/registration","/add1","/createToken","/getCurrentUser","/admin/deleteAllUsers").permitAll()
                .antMatchers("/admin/getAllUsers","/").hasAuthority("ADMIN")
                .antMatchers("/crudTeapot", "/static/**",
                        "/api/teapot/*","/check","/addQuestion","/quest","/checkQuestion",
                        "/addQuestionnaire","/chat/topic","/client","/message/**","/app/message","/chat","/upload","/test","/api/teapotPag")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer()).and().exceptionHandling().authenticationEntryPoint(new AuthEntryPoint());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}


