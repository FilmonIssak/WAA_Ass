


import miu.edu.lab4_Demo.Repo.LoggerRepo;
import miu.edu.lab4_Demo.Service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class LoggerServiceImpl implements LoggerService {
    @Autowired
    private LoggerRepo loggerRepo;


    @Override
    public void saveLogger(Logger logger) {
        loggerRepo.save(logger);
    }
}
