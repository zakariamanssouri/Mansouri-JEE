package ma.enset.ormjava.cas_users.repositories;

import ma.enset.ormjava.cas_users.entities.Role;
import ma.enset.ormjava.cas_users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String rolename);
}
