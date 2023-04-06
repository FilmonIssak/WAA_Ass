package miu.edu.lab1_post.Service.Impl;

import miu.edu.lab1_post.Domain.Post;
import miu.edu.lab1_post.Repo.PostRepo;
import miu.edu.lab1_post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;


    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.getById(id);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

//    @Override
//    public void update(Post post) {
//        postRepo.update(post);
//    }
}
