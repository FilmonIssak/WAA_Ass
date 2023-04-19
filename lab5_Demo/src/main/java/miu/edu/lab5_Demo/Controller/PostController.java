package miu.edu.lab5_Demo.Controller;

import miu.edu.lab5_Demo.Domain.Post;
import miu.edu.lab5_Demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var posts = postService.getAll();
        if(posts.isEmpty()) {
            return new ResponseEntity<>("Posts Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        var post = postService.getById(id);
        if(post == null) {
            return new ResponseEntity<>("Post Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
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
    public ResponseEntity<?> getPostTitle(@PathVariable String title) {
        var post = postService.findPostTitle(title);
        if(post == null) {
            return new ResponseEntity<>("Post Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
