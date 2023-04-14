package miu.edu.lab5_Demo.Service;

import miu.edu.lab5_Demo.Domain.User;
import miu.edu.lab5_Demo.Dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    public User getUserById(long id);
    public void saveUser(User user);
    public void updateUser(long id, UserDto userDto);
    public void deleteUser(long id);

    public List<User> findUserTitle(String title);
//    public User findUserTitle(String title);

    public List<User> findUserHaveMoreThanOnePost(int n);
}
