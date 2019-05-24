package br.org.cac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.org.cac.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/assets/**").permitAll();
		http.authorizeRequests().antMatchers("/css/**").permitAll();
		http.authorizeRequests().antMatchers("/img/**").permitAll();
		http.authorizeRequests().antMatchers("/js/**").permitAll();
		http.authorizeRequests().antMatchers("/scss/**").permitAll();
		http.authorizeRequests().antMatchers("/assetslogin/**").permitAll();
		
		http.authorizeRequests().antMatchers("/dashboard").authenticated();
		http.authorizeRequests().antMatchers("/").authenticated();
		http.authorizeRequests().antMatchers("/403").permitAll();
		http.authorizeRequests().antMatchers("/404").permitAll();
		http.authorizeRequests().antMatchers("/500").permitAll();
		http.authorizeRequests().antMatchers("/**/anterior").authenticated();
		http.authorizeRequests().antMatchers("/**/proximo").authenticated();
		http.authorizeRequests().antMatchers("/**/buscarpor").authenticated();
		http.authorizeRequests().antMatchers("/**/resetabusca").authenticated();
		
		/**
		 * Permissões para as URLs
		 */
		http.authorizeRequests().antMatchers("/api/v1/**").hasAuthority("ADMINISTRADOR");
		http.authorizeRequests().antMatchers("/acoes/**").hasAuthority("ADMINISTRADOR");
		http.authorizeRequests().antMatchers("/colaboradores/**").hasAuthority("ADMINISTRADOR");
		http.authorizeRequests().antMatchers("/doacoes/**").hasAuthority("ADMINISTRADOR");
		
		http.formLogin().loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/dashboard");
		
		http.logout().permitAll()
			.logoutSuccessUrl("/login")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/403");
		
		http.csrf().disable();
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
//		String idForEncode = "bcrypt";
//	    Map encoders = new HashMap<>();
//	    encoders.put(idForEncode, new BCryptPasswordEncoder());
//	    return new DelegatingPasswordEncoder(idForEncode, encoders);
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return new BCryptPasswordEncoder();
	}
}