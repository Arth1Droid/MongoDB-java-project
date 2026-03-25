package dev.br.arthdroid1.mongoproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import dev.br.arthdroid1.mongoproject.models.entities.Post;
import dev.br.arthdroid1.mongoproject.models.entities.User;
import dev.br.arthdroid1.mongoproject.repositories.PostRepository;
import dev.br.arthdroid1.mongoproject.repositories.UserRepository;
import dto.AuthorDTO;
import dto.CommentDTO;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/01/2011"),"Partiu viagem","Vou viajar para João Pessoa",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("30/01/2019"),"Bon jour","Acordando na França",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem irmão!",sdf.parse("21/01/2011"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite bastante!",sdf.parse("21/01/2011"), new AuthorDTO(bob));	
		CommentDTO c3 = new CommentDTO("Tenha um Bom Dia",sdf.parse("30/01/2019"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().add(c3);

		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);
		
		
	}

}
