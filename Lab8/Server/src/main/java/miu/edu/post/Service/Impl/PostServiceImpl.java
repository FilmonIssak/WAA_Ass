package miu.edu.post.Service.Impl;

import miu.edu.post.Domain.Post;
import miu.edu.post.Repo.PostRepo;
import miu.edu.post.Service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;
    PostServiceImpl (PostRepo postRepo){
        this.postRepo = postRepo;
    }


    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void updatePost(long id, Post post) {
        var existingPost = postRepo.findById(id);
        if(existingPost.isPresent()){
            existingPost.get().setTitle(post.getTitle());
            existingPost.get().setContent(post.getContent());
            existingPost.get().setAuthor(post.getAuthor());
            postRepo.save(existingPost.get());
//            return existingPost.get();
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }
}
