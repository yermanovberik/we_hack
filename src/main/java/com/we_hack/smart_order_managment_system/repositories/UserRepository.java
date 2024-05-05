package com.we_hack.smart_order_managment_system.repositories;

import com.we_hack.smart_order_managment_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIIN(String IIN);

}
