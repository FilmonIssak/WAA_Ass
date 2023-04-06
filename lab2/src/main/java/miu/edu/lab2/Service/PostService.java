package miu.edu.lab2.Service;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Dto.PostDto;

import java.util.List;


public interface PostService  {

    List<PostDto> getAll();
    PostDto getById(long id);
    public void save(PostDto postDto);
    void saveDto(PostDto postDto);

    void delete(long id);

    void update(long id, PostDto postDto);
}
