package com.vismotechnologies.blogsservice.service;

import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import com.vismotechnologies.blogsservice.model.UserDetailsInfoAdminModel;
import com.vismotechnologies.blogsservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {


    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Optional<UserDetailsInfoAdminModel>> findByName(String username) {
        UserDetailsInfo user = userRepository.findByName(username);
        return ResponseEntity.ok(Optional.of(new UserDetailsInfoAdminModel(user)));
    }

    public ResponseEntity<List<UserDetailsInfoAdminModel>> findAll() {
        List<UserDetailsInfo>  userDetailsInfoList =userRepository.findAll();
        return ResponseEntity.ok(
                userDetailsInfoList.stream().map(UserDetailsInfoAdminModel::new)
                        .collect(Collectors.toList())
        );
    }

    public UserDetailsInfo save(UserDetailsInfo user) {
        user.setPassward(passwordEncoder.encode(user.getPassward()));
        return userRepository.save(user);
    }

    public void deleteUserByName(int id) {
        userRepository.deleteById(id);
    }

    public UserDetailsInfoAdminModel editUser(UserDetailsInfo user) {
        Optional<UserDetailsInfo> userModel = userRepository.findById(user.getId());
        if (userModel.isEmpty()) {
            throw new UsernameNotFoundException("User not found" + user.getName());
        }
        user.setPassward(userModel.get().getPassward());
        UserDetailsInfo userDetailsInfo = userRepository.save(user);
        return new UserDetailsInfoAdminModel(userDetailsInfo);
    }
}
