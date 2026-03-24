package dev.br.arthdroid1.mongoproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.br.arthdroid1.mongoproject.models.entities.User;
import dev.br.arthdroid1.mongoproject.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
