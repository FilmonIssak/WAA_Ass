package miu.edu.lab2.Controller;

import miu.edu.lab2.Domain.User;
import miu.edu.lab2.Dto.UserDto;
import miu.edu.lab2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<UserDto> getAllUsers(){
        return (List<UserDto>) userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PostMapping("/update")
    public @ResponseBody void updateUser(int id, UserDto userDto){
        userService.updateUser(id, userDto);
    }

    @PostMapping("/add")
    public @ResponseBody void addNewUser(User user) {
        userService.saveUser(user);
    }


}
