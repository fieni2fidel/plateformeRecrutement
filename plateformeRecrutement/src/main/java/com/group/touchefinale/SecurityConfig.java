package com.group.touchefinale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity  
@EnableGlobalMethodSecurity(securedEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

	
	  @Autowired 
	  private UserDetailsService userDetailsService;
	  
	 @Autowired 
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	 //rechercher les utilisateurs et les roles
	 @Override 
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	//authentification avec un user, un mot de passe et un role
	// auth.inMemoryAuthentication().withUser("poisson").password("1234").roles("ADMIN","USER"); }
	
	 /* 
	 * //recuperer l'utilisateur et son role
	 * auth.jdbcAuthentication().usersByUsernameQuery("")
	 * .authoritiesByUsernameQuery("");
	 */ 
	 //authentification avec un user, un mot de passe et un role
	//BCrypt doit etre instancié dans main application
	 auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); 
	 
      }
	// definnir les droits dacces ajouter les filtres et acceder aux differentes ressources
	 @Override protected void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable();
	 //acceder a une ressource avec le role niveau 1
	  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	  http
	  	.authorizeRequests()
	  		.antMatchers("/login/**").permitAll()
	  		.antMatchers("/entreprisesx/**","/entreprises/**","/postulantsx/**","/postulants/**","/annoncesx/**","/autreinfosx/**",
	  				"/missionsx/**","/mailutilisateur/**","/annoncesatconstraintUn/**","/annoncesatconstraintMail/**",
	  				     "/annoposts/**","/annopostsx/**","/","/idannopost/**","/sendEmail/**","/sendAcceptHtmlEmail/**",
	  				     "/sendRefusHtmlEmail/**","/idEntrepriseForAnnopost/**","/idPostulantForAnnopost/**",
	  				     "/decisionannopostsx/**","/idAnnonceForAnnopost/**","/testentreprisesx/**",
	  				     "/nivodacceses/**","/nivodaccesesx/**","/modifypasswordentreprisesx/**","/annoncesatconstraintmailsearch/**",
	  				   "/entreprisesearch/**","/postulantsearch/**","/annoncesearch/**","/byRecruteurOrEntreprise/**",
	  				 "/experienceprofsx/**","/experienceprofs/**","/diplomes/**","/diplomesx/**",
	  				"/competencesx/**","/competences/**","/currivitaesx/**","/currivitaes/**",
	  				"/modifypasswordpostulantsx/**").permitAll();	
	  
/*	
	http
	  	.authorizeRequests()
	  		.antMatchers("/entreprisesx").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/entreprises").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/entreprisesx/**").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/entreprises/**").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		
	  		.antMatchers("/nivodaccesesx").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/nivodacceses").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/nivodaccesesx/**").hasAnyAuthority("ADMIN","ENTREPRISE")
	  		.antMatchers("/nivodacceses/**").hasAnyAuthority("ADMIN","ENTREPRISE");
	  		
	  		
			.antMatchers(HttpMethod.DELETE,"/entreprisesx").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/entreprises").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/entreprisesx/**").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/entreprises/**").hasAuthority("ADMIN")
	  		
	  		.antMatchers(HttpMethod.DELETE,"/nivodaccesesx").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/nivodacceses").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/nivodaccesesx/**").hasAuthority("ADMIN")
	  		.antMatchers(HttpMethod.DELETE,"/nivodacceses/**").hasAuthority("ADMIN");
	 
		
		 * http .authorizeRequests()
		 * .antMatchers(HttpMethod.GET,"/entreprisesx/**").hasAnyAuthority("ADMIN",
		 * "ENTREPRISE") .antMatchers(HttpMethod.DELETE,
		 * "/entreprisesx/**").hasAnyAuthority("ADMIN","ENTREPRISE")
		 * .antMatchers(HttpMethod.GET,"/entreprisesx/**").hasAnyAuthority("ENTREPRISE",
		 * "ADMIN") .anyRequest().authenticated();
		 */
		  

		/*
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/entreprisesx/**").
		 * hasAnyAuthority("ENTREPRISE","ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/entreprises/**").
		 * hasAnyAuthority("ENTREPRISE","ADMIN");
		 * 
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/entreprisesx/**").
		 * hasAnyAuthority("ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/entreprises/**").
		 * hasAnyAuthority("ADMIN");
		 * 
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/postulantsx/**").
		 * hasAnyAuthority("ENTREPRISE","POSTULANT","ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/postulants/**").
		 * hasAnyAuthority("ENTREPRISE","POSTULANT","ADMIN");
		 * 
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/postulantsx/**").
		 * hasAnyAuthority("POSTULANT","ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/postulants/**").
		 * hasAnyAuthority("POSTULANT","ADMIN");
		 * 
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/postulantsx/**").
		 * hasAnyAuthority("ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/postulants/**").
		 * hasAnyAuthority("ADMIN");
		 * 
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/nivodaccesesx/**").
		 * hasAnyAuthority("ENTREPRISE","POSTULANT","ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/nivodacceses/**").
		 * hasAnyAuthority("ENTREPRISE","POSTULANT","ADMIN");
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/nivodaccesesx/**").
		 * hasAnyAuthority("ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.PUT,"/nivodacceses/**").
		 * hasAnyAuthority("ADMIN");
		 * 
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/nivodaccesesx/**").
		 * hasAnyAuthority("ADMIN");
		 * http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/nivodacceses/**").
		 * hasAnyAuthority("ADMIN");
		 * 
		 */			 
	 
		
	 http.authorizeRequests().anyRequest().authenticated();
	 http.addFilter(new JWTAuthenticationFilter(authenticationManager())); 
	 http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	 
	 
		/*
		 * http.formLogin();
		 * http.authorizeRequests().antMatchers("/login/**","/register/**",
		 * "/entreprisesx/**").permitAll();
		 * http.authorizeRequests().anyRequest().authenticated();
		 */
	 

	  
	 }
	 
}

