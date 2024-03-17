package com.vismotechnologies.blogsservice.service;

import com.vismotechnologies.blogsservice.model.UserDetailsInfo;
import com.vismotechnologies.blogsservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {


    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Optional<UserDetailsInfo>> findByName(String username) {
        Optional<UserDetailsInfo> user = userRepository.findByName(username);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<List<UserDetailsInfo>> findAll() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    public UserDetailsInfo save(UserDetailsInfo user) {
        user.setPassward(passwordEncoder.encode(user.getPassward()));
        return userRepository.save(user);
    }

    public void deleteUserByName(int id) {
        userRepository.deleteById(id);
    }

    public UserDetailsInfo editUser(UserDetailsInfo user) {
        Optional<UserDetailsInfo> userModel = userRepository.findById(user.getId());
        if (userModel.isEmpty()) {
            throw new UsernameNotFoundException("User not found" + user.getName());
        }
        user.setPassward(userModel.get().getPassward());
        return userRepository.save(user);
    }
}
