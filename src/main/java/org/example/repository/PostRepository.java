package org.example.repository;

import org.example.model.Post;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;

// Stub
@Repository
public class PostRepository {
  ConcurrentSkipListMap<Long,Post> listSetPost = new ConcurrentSkipListMap();
  public volatile long count = 0;
  //ConcurrentSkipListSet<Post> listSetPost = new ConcurrentSkipListSet<>();
//  public List<Post> all() {
//    return Collections.emptyList();
//  }
//  public List<Post> all(){
//    return new ArrayList<>(listSetPost.values());
//  }
  public ConcurrentSkipListMap<Long, Post> all(){
    return listSetPost;
  }

//  public Optional<Post> getById(long id) {
//    return Optional.empty();
//  }
  public Optional<Post> getById(long id) {
    return Optional.ofNullable(listSetPost.get(id));
  }

  public Post save(Post post) {
    //System.out.println(listSetPost.size());
    if(post.getId()== 0){
      post.setId(count);
      listSetPost.put(count,post);
      count++;
    }else{
      listSetPost.replace(post.getId(),post);
    }
    Post obj = listSetPost.get((long)listSetPost.size()-1);
    return obj;
  }

  public Optional<Post> removeById(long id) {
    return Optional.ofNullable(listSetPost.remove(id));
  }
}
