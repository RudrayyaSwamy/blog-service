package com.vismotechnologies.blogsservice.config;

import com.vismotechnologies.blogsservice.model.UserDetailsEntity;
import com.vismotechnologies.blogsservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoSecurityServiceConfig  implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public UserInfoConfig loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailsEntity> userEntity=userRepository.findByName(username);
        return userEntity.map(UserInfoConfig::new)
                .orElseThrow(() ->new UsernameNotFoundException("User not found" +  username));

    }
}
