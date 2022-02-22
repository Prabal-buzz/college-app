package com.college.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }
	     
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	    
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	             .anonymous()
	             .and()
	             .authorizeRequests()
	            
//	            .antMatchers("/admin/user").hasAnyAuthority("SUPERADMIN")
	             .antMatchers("/admin/gallery/*").permitAll()     
	             .antMatchers("/front/css/style.css").permitAll()
	             .antMatchers("/admin/css/global.css").permitAll()
	             .antMatchers("/admin/**").authenticated()
	             .antMatchers("/admin/user").hasAnyAuthority("SUPERADMIN")
	            .antMatchers("/admin/result").hasAnyAuthority("ADMIN")
	            .anyRequest().permitAll()
	            .and()
	            .formLogin().loginPage("/admin/login").defaultSuccessUrl("/admin/student", true).permitAll()
	            .and()
	            .logout().permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/403")
	            ;
	    }
	     	

}
