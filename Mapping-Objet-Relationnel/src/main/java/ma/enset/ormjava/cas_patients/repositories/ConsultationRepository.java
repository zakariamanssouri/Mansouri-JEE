package ma.enset.ormjpa.repositories;
import ma.enset.ormjpa.entites.Consultation;
import ma.enset.ormjpa.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long>{
}
