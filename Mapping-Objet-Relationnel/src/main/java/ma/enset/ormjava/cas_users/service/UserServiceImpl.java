package ma.enset.ormjava.cas_users.service;

import lombok.AllArgsConstructor;
import ma.enset.ormjava.cas_patients.repositories.PatientRepository;
import ma.enset.ormjava.cas_users.entities.Role;
import ma.enset.ormjava.cas_users.entities.User;
import ma.enset.ormjava.cas_users.repositories.RoleRepository;
import ma.enset.ormjava.cas_users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);

    }
    @Override
    public User findUserByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }
    @Override
    public Role findRolByName(String rolename) {
        return roleRepository.findRoleByName(rolename);
    }
    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = findUserByUserName(username);
        Role role = findRolByName(rolename);
        if (user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);

        }
    }
}
