package dev.br.arthdroid1.mongoproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.br.arthdroid1.mongoproject.models.entities.Post;
import dev.br.arthdroid1.mongoproject.repositories.PostRepository;
import dev.br.arthdroid1.mongoproject.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;


	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
