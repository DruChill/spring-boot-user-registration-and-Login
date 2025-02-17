package net.enjoy.springboot.registrationlogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeHttpRequests((authorize) ->
                    authorize.requestMatchers("/register/**").permitAll()
                            .requestMatchers("/index").permitAll()
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/tienda").permitAll()
                            .requestMatchers("/polos").permitAll()
                            .requestMatchers("/polos/sizes").permitAll()
                            .requestMatchers("/pantalones").permitAll()
                            .requestMatchers("/pantalones/sizes").permitAll()
                            .requestMatchers("/vestidos").permitAll()
                            .requestMatchers("/vestidos/sizes").permitAll()
                            .requestMatchers("/comprar").permitAll()
                            .requestMatchers("/pagoExitoso").permitAll()
                            .requestMatchers("/users").hasRole("ADMIN")
                            .requestMatchers("/products/**").authenticated()
            ).formLogin(
                    form -> form
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/products", true)
                            .permitAll()
            ).logout(
                    logout -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .permitAll()
            );
    return http.build();
}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}