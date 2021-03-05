package pe.com.spring.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {
	
	/***
	 * To convert this application from web to console:
	 * 1.- Add below line in main method 
	 * 		System.exit(SpringApplication.exit(SpringApplication.run(BatchApplication.class, args)));
	 * 2.- Remove below line in properties file
	 * 		spring.batch.job.enabled=false
	 * 3.- Remove controller package
	 * 
	 * ***/
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BatchApplication.class, args);
	}

}
