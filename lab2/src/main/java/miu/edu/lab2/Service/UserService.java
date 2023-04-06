package miu.edu.lab2.Service;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Domain.User;
import miu.edu.lab2.Dto.UserDto;

import java.util.List;

public interface UserService {

    Iterable<UserDto> getAllUsers();
    public UserDto getUserById(long id);
    public void saveUser(User user);
    public void updateUser(long id, UserDto userDto);
    public void deleteUser(long id);
}
