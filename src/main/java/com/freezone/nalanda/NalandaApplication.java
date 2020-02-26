package com.freezone.nalanda;

import com.freezone.nalanda.domain.model.Guru;
import com.freezone.nalanda.domain.model.User;
import com.freezone.nalanda.infrastructure.persistence.jpaadaptor.H2UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.security.Principal;

@SpringBootApplication
public class NalandaApplication {

	@Autowired
	private H2UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(NalandaApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@PostConstruct
	public void loadSuperUser(){
		User user = new Guru();
		user.setFName("Admin");
		user.setLName("Super");
		user.setUserName("adminuseer");
		user.setPassword("password");
		user.setSuperUser(true);
		repository.save(user);
	}
}
