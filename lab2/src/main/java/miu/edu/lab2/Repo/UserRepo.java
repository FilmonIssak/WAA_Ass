package miu.edu.lab2.Repo;

import miu.edu.lab2.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
