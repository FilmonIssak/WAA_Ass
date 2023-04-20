package miu.edu.post.Controller;


import miu.edu.post.Domain.Post;
import miu.edu.post.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/v1/posts")
public class PostController {



    PostService postService;
    public  PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }


    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id,@RequestBody Post post){
        postService.updatePost(id, post);
    }

    @PostMapping()
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
////        var f = postService(savedPost);
//        if(savedPost != null)
//            return ResponseEntity<>(savedPost, HttpStatus.OK);
//        else
//            return ResponseEntity.badRequest().body("Post is not saved");
    }
}
