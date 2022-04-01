package ma.enset.ormjava.cas_patients.repositories;

import ma.enset.ormjava.cas_patients.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.nom like :nom")
    List<Patient> chercherPatients(@Param("nom") String nom);
}
