package com.thaicom.backend.service;

import com.thaicom.backend.entity.Social;
import com.thaicom.backend.entity.User;
import com.thaicom.backend.exception.UserException;
import com.thaicom.backend.repository.SocialRepository;
import com.thaicom.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class SocialService {

    @Autowired
    private SocialRepository repository;

//    @Autowired
    private final PasswordEncoder passwordEncoder;

    public SocialService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Social> findByUser(User user){
        return repository.findByUser(user);
    }

    public Social create(User user, String facebook, String line, String instagram){
        //TODO - Validate
        Social entity = new Social();

        entity.setUser(user);
        entity.setFacebook(facebook);
        entity.setLine(line);
        entity.setInstagram(instagram);

        return repository.save(entity);
    }
}
