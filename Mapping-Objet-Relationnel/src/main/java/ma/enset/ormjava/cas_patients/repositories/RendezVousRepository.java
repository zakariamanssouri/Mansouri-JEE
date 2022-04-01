package ma.enset.ormjava.cas_patients.repositories;

import ma.enset.ormjava.cas_patients.entites.RendezVous;
import ma.enset.ormjava.cas_patients.entites.StatusRDV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findByStatus(StatusRDV staus);
}
