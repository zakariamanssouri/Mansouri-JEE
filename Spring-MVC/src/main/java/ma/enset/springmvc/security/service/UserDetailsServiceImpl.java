package ma.enset.springmvc.security.service;

import ma.enset.springmvc.security.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("userservice")
public class UserDetailsServiceImpl implements UserDetailsService {
    private SecurityService securityService;

    public UserDetailsServiceImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        /*mapping */
        appUser.getAppRoles().forEach(appRole -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appRole.getRoleName());
            authorities.add(authority);
        });

        /*second way*/
      /*  Collection<GrantedAuthority> authorities1 =
                appUser.getAppRoles().stream().map(role -> {
                    new SimpleGrantedAuthority(role.getRoleName());
                }).collect(Collectors.toList());*/


        User user = new User(appUser.getUsername(), appUser.getPassword(), authorities);
        return user;
    }
}
