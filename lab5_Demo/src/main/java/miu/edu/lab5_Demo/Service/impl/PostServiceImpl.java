package miu.edu.lab5_Demo.Service.impl;

import miu.edu.lab5_Demo.Domain.Comment;
import miu.edu.lab5_Demo.Domain.Post;
import miu.edu.lab5_Demo.Dto.PostDto;
import miu.edu.lab5_Demo.Repo.CommentRepo;
import miu.edu.lab5_Demo.Repo.PostRepo;
import miu.edu.lab5_Demo.Repo.UserRepo;
import miu.edu.lab5_Demo.Service.PostService;
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
        return post;
    }

    @Override
    public void save(Post post) {

        postRepo.save(post);
    }

//    @Override
//    public void saveDto(PostDto postDto) {
//       Post post= modelMapper.map(postDto,Post.class);
//       postRepo.save(post);
//        System.out.println(post);
//    }

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
