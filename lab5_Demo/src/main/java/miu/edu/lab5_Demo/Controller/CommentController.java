package miu.edu.lab5_Demo.Controller;


import miu.edu.lab5_Demo.Dto.CommentDto;
import miu.edu.lab5_Demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentDto> getAll(){
        return commentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CommentDto getById(@PathVariable int id){
        return commentService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id){
        commentService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody CommentDto commentDto){
        commentService.save(commentDto);
    }


}
