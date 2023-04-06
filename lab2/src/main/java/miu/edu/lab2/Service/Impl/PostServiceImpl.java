package miu.edu.lab2.Service.Impl;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Dto.PostDto;
import miu.edu.lab2.Repo.PostRepo;
import miu.edu.lab2.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<PostDto> getAll() {
        List<Post> post = (List<Post>) postRepo.findAll();
//        PostDto pd = new PostDto();

        var d = post.stream().map(p->modelMapper.map(p,PostDto.class)).toList();


//        post.iterator().forEachRemaining(value -> pd.setTile(value.getTitle()));
//        post.iterator().forEachRemaining(value -> pd.setContent(value.getContent()));
//        post.iterator().forEachRemaining(value -> pd.setAuthor(value.getAuthor()));
        return d;
    }

    @Override
    public PostDto getById(long id) {

        var post = postRepo.findById(id);
        PostDto pd = new PostDto();
        post.ifPresent(value -> pd.setTile(value.getTitle()));
        post.ifPresent(value -> pd.setContent(value.getContent()));
        post.ifPresent(value -> pd.setAuthor(value.getAuthor()));
        return pd;
    }

    @Override
    public void save(PostDto postDto) {
        Post post= modelMapper.map(postDto,Post.class);

        postRepo.save(post);
        System.out.println(post);
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



//        var existingPost = postRepo.findById(post.getId()).orElse(null);
//        existingPost.setId(post.getId());
//        existingPost.setTitle(post.getTitle());
//        existingPost.setTitle(post.getTitle());
//        existingPost.setContent(post.getContent());
    }
}
