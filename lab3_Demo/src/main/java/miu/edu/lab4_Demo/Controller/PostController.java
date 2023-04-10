package miu.edu.lab3_Demo.Controller;

import miu.edu.lab3_Demo.Domain.Post;
import miu.edu.lab3_Demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
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

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }

    @GetMapping("/title/{title}")
    public List<Post> getPostTitle(@PathVariable String title) {
        return postService.findPostTitle(title);
    }

}
