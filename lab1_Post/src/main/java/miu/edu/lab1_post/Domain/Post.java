package miu.edu.lab1_post.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Post {

    long id;
    String title;
    String content;
    String author;
}
