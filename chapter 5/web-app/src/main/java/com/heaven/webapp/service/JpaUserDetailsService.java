package com.heaven.webapp.service;


import com.heaven.webapp.repository.UserRepository;
import com.heaven.webapp.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findUserByName(username);

        return u.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("User: " + username + " not found"));
    }
}
