package com.grupo.spent.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spent.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findUserByUsername(String username);
    User getUserByEmail(String email);
    Optional<User> findUserByEmail(String email);
    boolean existsUserByEmail(String email);
}