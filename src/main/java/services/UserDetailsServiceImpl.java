package services;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        domain.User applicationUser = userDAO.getUserByUsername(username);
        if (applicationUser.getUsername()==null) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority("Admin"));
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), auths);
    }
}