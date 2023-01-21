package org.example.service;

import org.example.exception.NotFoundException;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  //public List<Post> all() {
  public ConcurrentSkipListMap<Long, Post> all() {
    return repository.all();
  }

  public Optional<Post> getById(long id) {
    return repository.getById(id);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public Optional<Post> removeById(long id) {
    return repository.removeById(id);
  }
}

