 package com.tejait.batch15;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Batch15Application {
	
	private static final Logger logger=LogManager.getLogger(Batch15Application.class);	
	
	
		
	public static void main(String[] args) {
		
		SpringApplication.run(Batch15Application.class, args);
		
		logger. debug("Debug Level");  //Development Statge
		
		logger.info("Info Level"); //Production Stage
		
		logger.warn("Warn Level");// To show Warning Msgs
		
		logger.error("Error Level");// To show error msgs
		
		logger.fatal("Fatal Level");// To show server db issues logs
		
		//logger.trace("Trace Level");//To show trace (Each Stage) logs
	}

}
