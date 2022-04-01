package ma.enset.ormjava.cas_users.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    List<User> users = new ArrayList<>();
}
