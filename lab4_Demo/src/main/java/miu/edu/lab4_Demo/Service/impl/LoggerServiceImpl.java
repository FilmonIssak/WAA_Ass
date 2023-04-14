package miu.edu.lab4_Demo.Service.impl;


import miu.edu.lab4_Demo.Repo.LoggerRepo;
import miu.edu.lab4_Demo.Service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerRepo loggerRepo;





    @Override
    public void saveLogger(miu.edu.lab4_Demo.Domain.Logger logger) {
        loggerRepo.save(logger);
    }
}
