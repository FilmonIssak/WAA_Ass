package miu.edu.lab4_Demo;

import miu.edu.lab4_Demo.Service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.security.auth.callback.PasswordCallback;
import java.net.PasswordAuthentication;

@SpringBootApplication
public class Lab4DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4DemoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}



//	@Bean
//	public PasswordAuthentication passwordEncoder(){
//		return new PasswordAuthentication("d");
//	}

//	@Bean
//	public PasswordCallback passwordCallback(){
//		return new PasswordCallback("d");
//	}
}
