package miu.edu.lab5_Demo.Repo;

import miu.edu.lab5_Demo.Domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
