package by.bsu.trainingmanagement.service;

import by.bsu.trainingmanagement.dao.IUserDAO;
import by.bsu.trainingmanagement.entity.User;
import by.bsu.trainingmanagement.service.dto.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom user details service for Spring Security
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserDAO userDAO;

    @Autowired
    public CustomUserDetailsService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserPrincipal(user);
    }
}
