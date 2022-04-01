package ma.enset.ormjava;

import ma.enset.ormjava.cas_patients.entites.*;
import ma.enset.ormjava.cas_patients.repositories.ConsultationRepository;
import ma.enset.ormjava.cas_patients.repositories.MedecinRepository;
import ma.enset.ormjava.cas_patients.repositories.PatientRepository;
import ma.enset.ormjava.cas_patients.repositories.RendezVousRepository;
import ma.enset.ormjava.cas_users.entities.Role;
import ma.enset.ormjava.cas_users.entities.User;
import ma.enset.ormjava.cas_users.repositories.RoleRepository;
import ma.enset.ormjava.cas_users.repositories.UserRepository;
import ma.enset.ormjava.cas_users.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class OrmJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmJavaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			PatientRepository patientRepository,
			RendezVousRepository rendezVousRepository,
			MedecinRepository medecinRepository,
			ConsultationRepository consultationRepository,
			UserService userService
			) {
		return args -> {

			//création des patients
			String patientsnames[] = {"zakaria", "ahmed", "karim", "samia"};
			for (String patientsname : patientsnames) {
				Patient patient = new Patient(null, patientsname, new Date(), Math.random() > 0.5, null);
				patientRepository.save(patient);
			}

			//création des medecin
			String medecinnames[] = {"aicha", "samir", "khadija", "fatima"};
			for (String medecinname : medecinnames) {
				Medecin medecin = new Medecin(null, medecinname, medecinname + "@gmail.com", RandomString.make(), null);
				medecinRepository.save(medecin);
			}


			//création des rendezvous
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(1L).orElse(null), medecinRepository.findById(1L).orElse(null), null));
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(1L).orElse(null), medecinRepository.findById(2L).orElse(null), null));
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(1L).orElse(null), medecinRepository.findById(3L).orElse(null), null));
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(1L).orElse(null), medecinRepository.findById(2L).orElse(null), null));
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(2L).orElse(null), medecinRepository.findById(2L).orElse(null), null));
			rendezVousRepository.save(new RendezVous(null, new Date(), StatusRDV.PENDING, patientRepository.findById(3L).orElse(null), medecinRepository.findById(2L).orElse(null), null));


			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(1L).orElse(null)));
			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(2L).orElse(null)));
			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(3L).orElse(null)));
			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(4L).orElse(null)));
			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(5L).orElse(null)));
			consultationRepository.save(new Consultation(null, new Date(), "rapport", rendezVousRepository.findById(6L).orElse(null)));


			User user = new User();
			user.setUsername("zakaria");
			user.setPassword("123456");
			userService.addNewUser(user);


			User user1 = new User();
			user.setUsername("hicham");
			user.setPassword("123456");
			userService.addNewUser(user1);


			User user2 = new User();
			user.setUsername("youssef");
			user.setPassword("123456");
			userService.addNewUser(user2);

			Stream.of("STUDENT","ADMIN","USER").forEach(rolename->{
				Role role = new Role();
				role.setName(rolename);
				userService.addNewRole(role);
			});

			userService.addRoleToUser("zakaria","ADMIN");
			userService.addRoleToUser("zakaria","STUDENT");
			userService.addRoleToUser("zakaria","USER");

			userService.addRoleToUser("hicham","STUDENT");
			userService.addRoleToUser("hicham","USER");

			userService.addRoleToUser("youssef","ADMIN");
			userService.addRoleToUser("zakaria","USER");












		};
	}
}
