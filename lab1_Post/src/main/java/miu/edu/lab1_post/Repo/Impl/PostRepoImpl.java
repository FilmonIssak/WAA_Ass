package miu.edu.lab1_post.Repo.Impl;

import miu.edu.lab1_post.Domain.Post;
import miu.edu.lab1_post.Repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    public static List<Post> posts;

    private static long postId = 1;
    static {

        posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setId(postId++);
        post1.setTitle("The Communist Manifesto");
        post1.setContent("Book");
        post1.setAuthor("R.R Donnelley");

        Post post2 = new Post();
        post2.setId(postId++);
        post2.setTitle("The sun also rises");
        post2.setContent("Book");
        post2.setAuthor("Sons");

        Post post3 = new Post();
        post3.setId(postId++);
        post3.setTitle("Tragedy of the Commons");
        post3.setContent("Book");
        post3.setAuthor("United Nation");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
    }





    @Override
    public Post getById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public void save(Post post) {
        post.setId(postId);
        postId++;
        posts.add(post);

    }

    @Override
    public void delete(int id) {
        posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
//        Post toDelete = getById(id);
//        posts.remove(toDelete);
    }

    @Override
    public void update(int id, Post post) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(post.getTitle());
        toUpdate.setContent(post.getContent());
        toUpdate.setAuthor(post.getAuthor());
    }


}
