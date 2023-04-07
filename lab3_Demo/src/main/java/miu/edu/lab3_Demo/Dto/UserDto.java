package miu.edu.lab3_Demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab3_Demo.Domain.Post;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String name;
    private List<Post> posts;
}
