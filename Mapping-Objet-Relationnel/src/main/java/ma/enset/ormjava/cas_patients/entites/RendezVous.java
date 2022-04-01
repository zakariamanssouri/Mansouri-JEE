package ma.enset.ormjava.cas_patients.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private StatusRDV status;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezvous")
    private Consultation consultation;
}
