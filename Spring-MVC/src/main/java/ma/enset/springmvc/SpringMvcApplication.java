package ma.enset.springmvc;

import ma.enset.springmvc.entites.Patient;
import ma.enset.springmvc.repositories.PatientRepository;
import ma.enset.springmvc.security.entities.AppRole;
import ma.enset.springmvc.security.entities.AppUser;
import ma.enset.springmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner commandLineRunner(SecurityService securityService){
		return args -> {
			securityService.saveNewUser("zakaria","12345","12345");
			securityService.saveNewUser("admin","admin","admin");

			securityService.saveNewRole("ADMIN","");
			securityService.saveNewRole("USER","");

			securityService.addRoleToUser("zakaria","USER");
			securityService.addRoleToUser("admin","ADMIN");
			securityService.addRoleToUser("admin","USER");

			AppUser appUser = securityService.loadUserByUsername("zakaria");
			System.out.println("displaying user roles");
			appUser.getAppRoles().forEach(appRole -> {
				System.out.println(appRole);
			});


		};
	}
}
