package xyz.neomtech.gadm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class GadmBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GadmBackendServiceApplication.class, args);
	}

}
