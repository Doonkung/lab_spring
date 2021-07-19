package com.thaicom.backend.service;

import com.thaicom.backend.entity.Address;
import com.thaicom.backend.entity.Social;
import com.thaicom.backend.entity.User;
import com.thaicom.backend.repository.AddressRepository;
import com.thaicom.backend.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;




    public Optional<Address> findByUser(User user){
        return repository.findByUser(user);
    }

    public Address create(User user, String line1, String line2, String zipcode){
        //TODO - Validate

        // CREATE Address
        Address entity = new Address();

        entity.setUser(user);
        entity.setLine1(line1);
        entity.setLine2(line2);
        entity.setZipcode(zipcode);

        return repository.save(entity);
    }
}
