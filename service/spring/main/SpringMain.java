/**
 * @author Alexis I. Garcia Pagan
 * JAX-WS Service
 * SpringBoot Configuration
 * Development Day: 6/3/2018
 */

/*
 * This class is the main program to run the service
 */

package service.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import service.soap_configuration.WebConfigSB;

@SpringBootApplication
@Import({WebConfigSB.class})
public class SpringMain {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringMain.class, args);
	}
}
