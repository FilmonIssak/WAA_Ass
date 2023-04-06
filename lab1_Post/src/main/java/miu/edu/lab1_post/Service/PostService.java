package miu.edu.lab1_post.Service;

import miu.edu.lab1_post.Domain.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();
    Post getById(int id);
    void save(Post post);

    void delete(int id);

//    void update(Post post);
}
