package miu.edu.lab3_Demo.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Fetch(FetchType.SELECT)
    @JsonManagedReference
    @JoinColumn(name = "posts")
    private List<Post> posts;

    public void addPostToUser(Post post){
        posts.add(post);
    }
}
