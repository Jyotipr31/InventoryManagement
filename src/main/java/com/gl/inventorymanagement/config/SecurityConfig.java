package com.gl.inventorymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Order(1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Basant")
//                .password(encoder.encode("Pwd1"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("John")
//                .password(encoder.encode("Pwd2"))
//                .roles("USER","ADMIN","HR")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login","/register/user").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("get/seller/**").hasRole("ADMIN")
//                .and()
//                .httpBasic();
    	
//    	http.csrf().disable()
//        .authorizeHttpRequests().requestMatchers("/register/user","/add/seller","/add/product/{id}").permitAll().and()
//        .authorizeHttpRequests().
//        requestMatchers("api-seller/get","/placeorder/{ids}",
//        		"/add/order","/register/customer","api-admin/getCustomer","api-admin/getAllOrderProduct")
//        .hasRole("ADMIN").and()
//        .httpBasic();
    	http.csrf().disable()
        .authorizeHttpRequests().requestMatchers("/register/user").permitAll().and()
        .authorizeHttpRequests().requestMatchers("/placeorder/{ids}","api-customer").hasRole("CUSTOMER").and()
        .authorizeHttpRequests().requestMatchers("api-all/**").hasAnyRole("ADMIN","SELLER","CUSTOMER").and()
        .authorizeHttpRequests().requestMatchers("api-seller/**").hasRole("ADMIN").and().httpBasic();
         
        return http.build(); 
    	
//        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
      authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
