package com.thaicom.backend.repository;

import com.thaicom.backend.entity.Address;
import com.thaicom.backend.entity.Social;
import com.thaicom.backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, String> {
    Optional<Address> findByUser(User user);
}
