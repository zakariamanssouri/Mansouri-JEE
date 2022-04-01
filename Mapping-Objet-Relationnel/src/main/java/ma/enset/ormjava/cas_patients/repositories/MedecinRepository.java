package ma.enset.ormjpa.repositories;
import ma.enset.ormjpa.entites.Medecin;
import ma.enset.ormjpa.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long>{
}
