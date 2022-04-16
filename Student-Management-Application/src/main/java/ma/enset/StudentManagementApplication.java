package ma.enset;

import ma.enset.security.entities.AppUser;
import ma.enset.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	//@Bean
	CommandLineRunner commandLineRunner(SecurityService securityService) {
		return args -> {
			securityService.saveNewUser("zakaria", "1234", "1234");
			securityService.saveNewUser("admin", "admin", "admin");
			securityService.saveNewRole("ADMIN", "");
			securityService.saveNewRole("USER", "");

			securityService.addRoleToUser("zakaria","USER");
			securityService.addRoleToUser("admin","USER");
			securityService.addRoleToUser("admin","ADMIN");
		};
	}
}
