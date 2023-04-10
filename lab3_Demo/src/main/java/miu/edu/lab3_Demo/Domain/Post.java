package miu.edu.lab3_Demo.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    private String author;

     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "comments")
     private List<Comment> comments;


    public void addCommentToPost(Comment comment){
        comments.add(comment);
    }

}
