package dev.br.arthdroid1.mongoproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.br.arthdroid1.mongoproject.models.entities.User;
import dev.br.arthdroid1.mongoproject.repositories.UserRepository;
import dev.br.arthdroid1.mongoproject.services.exceptions.ObjectNotFoundException;
import dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User insert(User user) {
		return repository.insert(user);
	}
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public User update(User user) {
		User searchedUser = repository.findById(user.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		updatedData(searchedUser,user);
		return repository.save(searchedUser);
	}
	
	private void updatedData(User searchedUser, User user) {
		searchedUser.setName(user.getName());
		searchedUser.setEmail(user.getEmail());
		
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

}
