package ma.enset.ormjava.cas_users.service;

import ma.enset.ormjava.cas_users.entities.Role;
import ma.enset.ormjava.cas_users.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface UserService {
    User addNewUser(User user);

    Role addNewRole(Role role);

    User findUserByUserName(String username);

    Role findRolByName(String rolename);

    void addRoleToUser(String username, String rolename);
}
