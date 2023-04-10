package miu.edu.lab4_Demo.Service;

import miu.edu.lab4_Demo.Domain.Post;
import miu.edu.lab4_Demo.Dto.PostDto;

import java.util.List;


public interface PostService  {

    List<Post> getAll();
    Post getById(long id);
    public void save(Post poso);
//    void saveDto(Post postDto);

    void delete(long id);

    void update(long id, PostDto postDto);

    public List<Post> findPostTitle(String title);
}
