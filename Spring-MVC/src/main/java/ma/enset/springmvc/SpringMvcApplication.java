package ma.enset.springmvc;

import ma.enset.springmvc.entites.Patient;
import ma.enset.springmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(null, "Hassan", new Date(), false,10)
			);
			patientRepository.save(
					new Patient(null, "karim", new Date(), true,300)
			);
			patientRepository.save(
					new Patient(null, "salim", new Date(), false,40)
			);
			patientRepository.save(
					new Patient(null, "ahmed", new Date(), false,99)
			);
			patientRepository.findAll().forEach(patient -> {
				System.out.println(patient.getId()+" "+patient.getNom());
			});

		};
	}
}
