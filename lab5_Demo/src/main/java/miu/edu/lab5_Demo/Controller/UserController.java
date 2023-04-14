package miu.edu.lab5_Demo.Controller;

import miu.edu.lab5_Demo.Domain.User;
import miu.edu.lab5_Demo.Dto.UserDto;
import miu.edu.lab5_Demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping
    public @ResponseBody void updateUser(int id, UserDto userDto){
        userService.updateUser(id, userDto);
    }

    @PostMapping
    public @ResponseBody void addNewUser(User user) {
        userService.saveUser(user);
    }

    @GetMapping("/title{title}")
    public List<User> getUserTitle(@PathVariable String title) {
        return (List<User>) userService.findUserTitle(title);
    }

    @GetMapping("/userPost{n}")
    public List<User> getUserHaveMoreThanOnePost(@PathVariable int n) {
        return userService.findUserHaveMoreThanOnePost(n);
    }

}
