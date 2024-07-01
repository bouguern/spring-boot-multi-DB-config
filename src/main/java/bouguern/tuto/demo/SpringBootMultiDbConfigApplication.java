package bouguern.tuto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootMultiDbConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDbConfigApplication.class, args);
		log.info("Application started successfully.");
	}

}
