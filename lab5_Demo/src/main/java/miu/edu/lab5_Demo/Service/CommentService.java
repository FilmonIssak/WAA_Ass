package miu.edu.lab5_Demo.Service;

import miu.edu.lab5_Demo.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAll();
    CommentDto getById(long id);
    public void save(CommentDto commentDto);

    void delete(long id);

    void update(long id, CommentDto commentDto);

//    List<CommentDto> findCommentByName(String name);
}
