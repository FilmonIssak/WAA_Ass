package miu.edu.lab2.Service.Impl;

import miu.edu.lab2.Domain.User;
import miu.edu.lab2.Dto.UserDto;
import miu.edu.lab2.Repo.UserRepo;
import miu.edu.lab2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Override
    public Iterable<UserDto> getAllUsers() {

        var user = userRepo.findAll();
        UserDto uD = new UserDto();
        user.iterator().forEachRemaining(value -> uD.setName(value.getName()));
        user.iterator().forEachRemaining(value-> uD.setPosts(value.getPosts()));
        return (Iterable<UserDto>) uD;
    }

    @Override
    public UserDto getUserById(long id) {

        var user = userRepo.findById(id);
        UserDto uD = new UserDto();
            user.ifPresent(value -> uD.setName(value.getName()));
            user.ifPresent(value-> uD.setPosts(value.getPosts()));

        return uD;

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

//        var existingUser = userRepo.findById(user.getId()).orElse(null);
//        existingUser.setId(user.getId());
//        existingUser.setName(user.getName());
//        existingUser.setPosts(user.getPosts());
    }


    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}
