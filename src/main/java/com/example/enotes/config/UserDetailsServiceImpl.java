package com.example.enotes.config;

import com.example.enotes.entities.UserDtls;
import com.example.enotes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDtls user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }else{
            CustomUserDtls customUserDtls = new CustomUserDtls(user);
            return customUserDtls;
        }
    }
}
