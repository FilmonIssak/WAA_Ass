package miu.edu.lab3_Demo.Service;

import miu.edu.lab3_Demo.Domain.Post;
import miu.edu.lab3_Demo.Dto.PostDto;

import java.util.List;


public interface PostService  {

    List<Post> getAll();
    Post getById(long id);
    public void save(PostDto postDto, Long userId);
    void saveDto(PostDto postDto);

    void delete(long id);

    void update(long id, PostDto postDto);

    public List<Post> findPostTitle(String title);
}
