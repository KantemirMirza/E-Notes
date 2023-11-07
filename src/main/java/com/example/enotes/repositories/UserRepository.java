package com.example.enotes.repositories;

import com.example.enotes.entities.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDtls,Integer> {

     UserDtls findByEmail(String email);
}
