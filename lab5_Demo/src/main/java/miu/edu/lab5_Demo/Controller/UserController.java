package miu.edu.lab5_Demo.Controller;

import miu.edu.lab5_Demo.Domain.User;
import miu.edu.lab5_Demo.Dto.UserDto;
import miu.edu.lab5_Demo.Dto.response.LoginResponse;
import miu.edu.lab5_Demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        var users = userService.getAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity<>("Users Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        var user = userService.getUserById(id);
//        return userService.getUserById(id);
        if(user == null) {
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
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
    public ResponseEntity<?> getUserTitle(@PathVariable String title) {
        var userTitle = userService.findUserTitle(title);
        if(userTitle.isEmpty()) {
            return new ResponseEntity<>("User with title Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTitle,HttpStatus.OK);
    }

    @GetMapping("/userPost{n}")
    public ResponseEntity<?> getUserHaveMoreThanOnePost(@PathVariable int n) {
        var userPost = userService.findUserHaveMoreThanOnePost(n);
        if(userPost.isEmpty()) {
            return new ResponseEntity<>("User with moreThan one Post Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userPost, HttpStatus.OK);
    }

}
