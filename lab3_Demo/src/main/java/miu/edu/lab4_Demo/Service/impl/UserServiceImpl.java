package miu.edu.lab3_Demo.Service.impl;


import miu.edu.lab3_Demo.Domain.Comment;
import miu.edu.lab3_Demo.Domain.Post;
import miu.edu.lab3_Demo.Domain.User;
import miu.edu.lab3_Demo.Dto.UserDto;
import miu.edu.lab3_Demo.Repo.CommentRepo;
import miu.edu.lab3_Demo.Repo.PostRepo;
import miu.edu.lab3_Demo.Repo.UserRepo;
import miu.edu.lab3_Demo.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    CommentRepo commentRepo;



    @Autowired
    ModelMapper modelMapper;



    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }



    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).get();

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }


    @Override
    public void updateUser(long id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow();
        user.setName(userDto.getName());
        user.setPosts(userDto.getPosts());
        userRepo.save(user);
    }


    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }


    public List<User> findUserTitle(String title){
        var user = userRepo.getTitle(title);
        return (List<User>) user;
    }

    @Override
    public List<User> findUserHaveMoreThanOnePost(int n) {
        return userRepo.findUserByPostsGreaterThan(n);
    }


}
