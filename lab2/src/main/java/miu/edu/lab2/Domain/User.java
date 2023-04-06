package miu.edu.lab2.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;


    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Post> posts;
}
