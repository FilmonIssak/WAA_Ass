package miu.edu.lab1_post.Repo;

import miu.edu.lab1_post.Domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepo {

    public Post getById(int id);
    public List<Post> getAll();
    public void save(Post post);

    public void delete(int id);

    public void update(int id, Post post);

}
