package miu.edu.lab4_Demo.Repo;


import miu.edu.lab4_Demo.Domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
