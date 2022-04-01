package ma.enset.ormjpa.repositories;
import ma.enset.ormjpa.entites.Patient;
import ma.enset.ormjpa.entites.RendezVous;
import ma.enset.ormjpa.entites.StatusRDV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long>{
    List<RendezVous> findByStatus(StatusRDV staus);
}
