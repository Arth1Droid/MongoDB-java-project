package dev.br.arthdroid1.mongoproject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.br.arthdroid1.mongoproject.models.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
