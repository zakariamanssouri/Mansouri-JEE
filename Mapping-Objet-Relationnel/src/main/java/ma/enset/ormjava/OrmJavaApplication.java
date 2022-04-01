package ma.enset.ormjava;

import ma.enset.ormjava.cas_patients.entites.*;
import ma.enset.ormjava.cas_patients.repositories.ConsultationRepository;
import ma.enset.ormjava.cas_patients.repositories.MedecinRepository;
import ma.enset.ormjava.cas_patients.repositories.PatientRepository;
import ma.enset.ormjava.cas_patients.repositories.RendezVousRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmJavaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository) {
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


			System.out.println("========================");
			System.out.println("affichage des patients qui ont le nom : zakaria");
			List<Patient> patients = patientRepository.chercherPatients("%zakaria%");
			if (patients != null) {
				for (Patient patient : patients) {
					System.out.println(patient.getNom()+" "+patient.getId()+" "+patient.getDateNaissance());
				}
			}
			System.out.println("========================");

		};
	}
}
