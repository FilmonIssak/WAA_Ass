package miu.edu.lab3_Demo.Service.impl;

import miu.edu.lab3_Demo.Domain.Comment;
import miu.edu.lab3_Demo.Domain.Post;
import miu.edu.lab3_Demo.Dto.PostDto;
import miu.edu.lab3_Demo.Repo.CommentRepo;
import miu.edu.lab3_Demo.Repo.PostRepo;
import miu.edu.lab3_Demo.Repo.UserRepo;
import miu.edu.lab3_Demo.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<Post> getAll() {
        List<Post> post = (List<Post>) postRepo.findAll();
        for (Post co : post){
            List<Comment> c = (List<Comment>)commentRepo.findAll();
            co.setComments(c);
        }
        return post;
    }

    @Override
    public Post getById(long id) {
        var post = postRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        var c = commentRepo.findById(id);
        post.addCommentToPost(c.get());
        return post;
    }

    @Override
    public void save(PostDto postDto, Long userId) {
        var user = userRepo.findById(userId);

        Post post= modelMapper.map(postDto,Post.class);
        if (user.isPresent()) user.get().addPostToUser(post);
        System.out.println("--------"+user.get());
        userRepo.save(user.get());
        postRepo.save(post);
    }

    @Override
    public void saveDto(PostDto postDto) {
       Post post= modelMapper.map(postDto,Post.class);
       postRepo.save(post);
        System.out.println(post);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(long id, PostDto postDto) {
        Post p = postRepo.findById(id).orElseThrow();
        p.setTitle(postDto.getTile());
        p.setContent(postDto.getContent());
        p.setAuthor(postDto.getAuthor());
        postRepo.save(p);
    }

    @Override
    public List<Post> findPostTitle(String title) {
        return (List<Post>) postRepo.getTitle(title);
    }


}
