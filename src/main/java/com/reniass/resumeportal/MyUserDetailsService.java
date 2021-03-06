package com.reniass.resumeportal;

import com.reniass.resumeportal.models.MyUserDetails;
import com.reniass.resumeportal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        userOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return new MyUserDetails(userOptional.get());

    }
}
