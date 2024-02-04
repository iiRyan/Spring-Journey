package com.spring.journey.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

        // Add support for JDBC
        @Bean
        public UserDetailsManager detailsManager(DataSource dataSource) {

                return new JdbcUserDetailsManager(dataSource);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(configurer -> configurer
                                // * Any request to the app must be authenticated.
                                .requestMatchers("/").hasRole("EMPLOYEE") // * The "**" means all subdirectory
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                                .formLogin(form -> // * We are customizing the form login process.
                                form.loginPage("/showLoginPage") // * specifies the path to the login page.
                                                .loginProcessingUrl("/authenticationTheUser") // * Login form should
                                                                                              // * POST data to this URL
                                                                                              // * for

                                                .permitAll() // * Allow everyone to see login page no need to be logged
                                                             // in

                                )
                                .logout(logout -> logout.permitAll()// * Invalidate user's HTTP session and remove
                                                                    // * session cookies.
                                )
                                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

                return http.build();
        }

        // ! Hard-Codded.
        /**
         * @Bean
         *       public InMemoryUserDetailsManager userDetailsManager() {
         *       UserDetails john = User.builder()
         *       .username("john")
         *       .password("{noop}test123")
         *       .roles("EMPLOYEE")
         *       .build();
         *       UserDetails mary = User.builder()
         *       .username("mary")
         *       .password("{noop}test123")
         *       .roles("EMPLOYEE", "MANAGER")
         *       .build();
         *       UserDetails susan = User.builder()
         *       .username("susan")
         *       .password("{noop}test123")
         *       .roles("EMPLOYEE", "MANAGER", "ADMIN")
         *       .build();
         *       return new InMemoryUserDetailsManager(john, mary, susan);
         *       }
         **/
}
