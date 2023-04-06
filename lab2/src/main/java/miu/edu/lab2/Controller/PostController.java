package miu.edu.lab2.Controller;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Dto.PostDto;
import miu.edu.lab2.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> getAll(){
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PostDto getById(@PathVariable int id){
        return postService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody PostDto post){
        postService.save(post);
    }
}
