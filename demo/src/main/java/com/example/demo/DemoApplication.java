package com.example.demo;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	Keycloak keycloak() {
		return KeycloakBuilder.builder()
				.serverUrl("http://localhost:9900")
				.realm("compta-realm")
				.clientId("office-client")
				.grantType(OAuth2Constants.PASSWORD)
				.username("wiam1")
				.password("1234")
				.build();
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//
//		UserDetails user = User.withDefaultPasswordEncoder() // (1)
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		UserDetails admin = User.withDefaultPasswordEncoder() // (2)
//				.username("admin")
//				.password("password")
//				.roles("USER","ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin); // (3)
//	}
}
