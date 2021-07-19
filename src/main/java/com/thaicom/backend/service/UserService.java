package com.thaicom.backend.service;

import com.thaicom.backend.entity.User;
import com.thaicom.backend.exception.UserException;
import com.thaicom.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

//    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public User create(String email, String password, String name) throws UserException {
        if(Objects.isNull(email)){
            throw UserException.emailNull();
        }
        if(Objects.isNull(name)){
            throw UserException.nameNull();
        }
        if(Objects.isNull(password)){
            throw UserException.passwordNull();
        }

        //verify
        if (repository.existsByEmail(email)) {
            throw UserException.emailExisting();
        }


        User entity = new User();
        entity.setName(name);
        entity.setEmail(email);
        entity.setPassword(passwordEncoder.encode(password));

        return repository.save(entity);
    }


    public boolean matchPassword(String password, String password1) {
        return passwordEncoder.matches(password, password1);
    }

    public Optional<User> findByid(String userId) {
        return repository.findById(userId);
    }
}
