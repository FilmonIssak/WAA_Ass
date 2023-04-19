package miu.edu.lab5_Demo.Controller;


import miu.edu.lab5_Demo.Dto.CommentDto;
import miu.edu.lab5_Demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var comments = commentService.getAll();
        if(comments.isEmpty()) {
            return new ResponseEntity<>("Comments Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        var comments = commentService.getById(id);
        if(comments == null) {
            return new ResponseEntity<>("Comment Not Found With the Id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
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
