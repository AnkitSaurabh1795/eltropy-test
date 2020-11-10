package com.eltropy.test.bankingsystem;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
public class BaseApplication {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    public static void main(String[] args) {
    	LOGGER.info("Starting Application");
        SpringApplication.run(BaseApplication.class, args);
    }

 
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseApplication.class);

}
