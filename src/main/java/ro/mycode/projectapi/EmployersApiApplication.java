package ro.mycode.projectapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.EmployeeService;
import view.ViewEmployer;

@SpringBootApplication
public class EmployersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployersApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ViewEmployer viewEmployer){
		return args -> {

			viewEmployer.play();

		};

	}
}
