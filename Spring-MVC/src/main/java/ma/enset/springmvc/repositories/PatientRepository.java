package ma.enset.springmvc.repositories;

import ma.enset.springmvc.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
