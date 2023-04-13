package com.qzce.withteam.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                    .antMatchers("/user/**").authenticated()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                        .loginPage("/login/do")
                        .loginProcessingUrl("/login/chk")
                        .usernameParameter("id")
                        .passwordParameter("pw")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                .and()
                    .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                .and()
                .csrf().disable();
//                .and()
//                .oauth2Login()
//                .userInfoEndpoint().userService();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/static/js/**", "/static/css/**");
    }

}
