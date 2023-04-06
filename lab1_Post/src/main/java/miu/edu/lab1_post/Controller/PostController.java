package miu.edu.lab1_post.Controller;

import miu.edu.lab1_post.Domain.Post;
import miu.edu.lab1_post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Post getById(@PathVariable int id){
        return postService.getById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }
}
