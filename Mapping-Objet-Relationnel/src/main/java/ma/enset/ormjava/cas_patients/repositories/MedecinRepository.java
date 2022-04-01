package ma.enset.ormjava.cas_patients.repositories;
import ma.enset.ormjava.cas_patients.entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
