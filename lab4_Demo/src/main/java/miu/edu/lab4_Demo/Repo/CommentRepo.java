package miu.edu.lab4_Demo.Repo;

import miu.edu.lab4_Demo.Domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {



}
