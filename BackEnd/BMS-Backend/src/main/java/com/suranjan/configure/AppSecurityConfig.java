package com.suranjan.configure;

 import java.util.Collections;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpMethod;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.authentication.ProviderManager;
 import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;


import com.suranjan.service.CustomUserDetailsService;

@Configuration
public class AppSecurityConfig  {

	 @Autowired
	 private CustomUserDetailsService customerUserDetailsService;
	
	 @Bean
	 public SecurityFilterChain springSecurityConfiguration (HttpSecurity http) throws Exception {
		 
		 
		 http.authorizeHttpRequests().
		 antMatchers(HttpMethod.POST,"/api/customers/admin/register")
		 .permitAll()
		 .antMatchers("/api/customers/all/customers",
				      "/api/customers/pagination/paginationdto",
				      "/api/customers/delete/customer/{id}",
				      "/api/customers/customer/{email}",
				      "/api/customers/all/customers",
				      "/api/customers/delete/customer/{id}"
				      )
		 .authenticated()
		 .and()
		 .csrf().disable().formLogin().and()
		 .httpBasic();
		 		 

		  return http.build();
	}

    @Bean
    AuthenticationManager authenticationManager()
            throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(Collections.singletonList(provider));
    }

	 @Bean
	 
	    BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	 }
}
