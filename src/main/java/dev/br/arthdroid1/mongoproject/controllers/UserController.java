package dev.br.arthdroid1.mongoproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.br.arthdroid1.mongoproject.models.entities.User;
import dev.br.arthdroid1.mongoproject.services.UserService;
import dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).toList();

		return ResponseEntity.ok().body(listDTO);

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@RequestParam String id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));

	}
}
