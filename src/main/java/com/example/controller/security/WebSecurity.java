package com.example.controller.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	BCryptPasswordEncoder bpasswordEncoder;
	LoadUserDetails userDetails;
	
	@Autowired
	public WebSecurity(BCryptPasswordEncoder bpasswordEncoder,LoadUserDetails userDetails) {	
		this.bpasswordEncoder=bpasswordEncoder;
		this.userDetails=userDetails;
	}
	
	public LogInFilter createLogInFilter() throws Exception {
		LogInFilter logInFilter=new LogInFilter();
		logInFilter.setAuthenticationManager(authenticationManager());	
		//override the default "/login" path provided by spring security
		logInFilter.setFilterProcessesUrl("/users/login");
		return logInFilter;
	}
	public TokenFilter createAuthFilter() throws Exception {
		TokenFilter authenticationFilter=new TokenFilter(authenticationManager());
		return authenticationFilter;
	}
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
        .antMatchers("/users/*").permitAll().anyRequest().authenticated().and().addFilter(createAuthFilter()).addFilter(createLogInFilter());
	}
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetails).passwordEncoder(bpasswordEncoder);
		
	}
}

 
