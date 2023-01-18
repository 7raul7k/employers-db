package ro.mycode.employerAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.employerAPI.repo.EmployerRepo;
import ro.mycode.employerAPI.view.ViewEmployer;

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
