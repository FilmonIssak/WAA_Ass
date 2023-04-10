package miu.edu.lab4_Demo.Service;

import miu.edu.lab4_Demo.Domain.Logger;
import org.springframework.stereotype.Service;

@Service
public interface LoggerService {
    public void saveLogger(Logger logger);
}
