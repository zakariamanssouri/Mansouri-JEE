package ma.enset.ormjava.cas_patients.repositories;

import ma.enset.ormjava.cas_patients.entites.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long>
{

}
