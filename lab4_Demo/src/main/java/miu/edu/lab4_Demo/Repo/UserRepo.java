package miu.edu.lab4_Demo.Repo;

import miu.edu.lab4_Demo.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select p from User p where count(p.posts)>=:n")
    public List<User> findUserByPostsGreaterThan(int n);

    @Query("select distinct p from Post p where p.title =: title")
    public User getTitle(String title);

}
