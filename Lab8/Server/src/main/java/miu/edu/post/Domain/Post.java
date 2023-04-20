package miu.edu.post.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue
    long id;

    String title;
    String content;
    String author;


}
