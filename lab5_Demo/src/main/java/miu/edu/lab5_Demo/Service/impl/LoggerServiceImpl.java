package miu.edu.lab5_Demo.Service.impl;


import miu.edu.lab5_Demo.Domain.Logger;
import miu.edu.lab5_Demo.Repo.LoggerRepo;
import miu.edu.lab5_Demo.Service.LoggerService;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
//    @Autowired
    private LoggerRepo loggerRepo;

    LoggerServiceImpl(LoggerRepo loggerRepo){
        this.loggerRepo = loggerRepo;
    }


    @Override
    public void saveLogger(Logger logger) {
        loggerRepo.save(logger);

    }
}
