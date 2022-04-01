package ma.enset.ormjava.cas_users.repositories;

import ma.enset.ormjava.cas_users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
