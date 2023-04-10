package miu.edu.lab4_Demo.Service.impl;

import miu.edu.lab4_Demo.Domain.Comment;
import miu.edu.lab4_Demo.Dto.CommentDto;
import miu.edu.lab4_Demo.Repo.CommentRepo;
import miu.edu.lab4_Demo.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<CommentDto> getAll() {
        List<Comment> comment = (List<Comment>) commentRepo.findAll();
        var com = comment.stream().map(p->modelMapper.map(p,CommentDto.class)).toList();
        return com;
    }

    @Override
    public CommentDto getById(long id) {
        var comment = commentRepo.findById(id);
        CommentDto cD = new CommentDto();
//        var d = comment.map(o->modelMapper.map(o, CommentDto.class));
        comment.ifPresent(value -> cD.setName(value.getName()));
        return cD;
    }

    @Override
    public void save(CommentDto commentDto) {
        Comment comment= modelMapper.map(commentDto,Comment.class);
        commentRepo.save(comment);
        System.out.println(comment);
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(long id, CommentDto commentDto) {
        Comment comment = commentRepo.findById(id).orElseThrow();
        comment.setName(commentDto.getName());
        commentRepo.save(comment);
    }


}
