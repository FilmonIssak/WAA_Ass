package miu.edu.post.Service;
import miu.edu.post.Domain.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    Post getPostById(Long id);

    Post savePost(Post post);

    void updatePost(long id, Post post);

    void deletePost(Long id);
}
