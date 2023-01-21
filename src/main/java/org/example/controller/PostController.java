package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Post;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  public static final String APPLICATION_JSON = "application/json";
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
//  public void all(HttpServletResponse response) throws IOException {
  //public List<Post> all(){
  public ConcurrentSkipListMap<Long, Post> all(){
//    response.setContentType(APPLICATION_JSON);
//    final var data = service.all();
//    final var gson = new Gson();
//    response.getWriter().print(gson.toJson(data));
    return service.all();
  }

  @GetMapping("/{id}")
//  public void getById(@PathVariable long id, HttpServletResponse response) throws IOException {
  public Optional<Post> getById(@PathVariable long id) {
//    response.setContentType(APPLICATION_JSON);
//    final var gson = new Gson();
//    final Optional<Post> data = service.getById(id);
//    if(data.isEmpty()){
//      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//      response.getWriter().print("id: " + id + " not found");
//      return;
//    }
//    response.getWriter().print(gson.toJson(data));
    return service.getById(id);
  }

  @PostMapping
//  public void save(String body, HttpServletResponse response) throws IOException {
  public Post save(@RequestBody Post body){
//    response.setContentType(APPLICATION_JSON);
//    final var gson = new Gson();
//    final Post post = gson.fromJson(body, Post.class);
//    final Post data = service.save(post);
//    response.getWriter().print(gson.toJson(data));
    return service.save(body);
  }

  @DeleteMapping("/{id}")
  //public void removeById(@PathVariable long id, HttpServletResponse response) throws IOException{
  public void removeById(@PathVariable long id){
//    response.setContentType(APPLICATION_JSON);
//    final var gson = new Gson();
//    final Optional<Post> data = service.removeById(id);
//    if(data.isEmpty()){
//      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//      response.getWriter().print("id: " + id + " not found");
//    }
//    response.getWriter().print(gson.toJson(data));
    service.removeById(id);
  }
}
