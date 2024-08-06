package com.grupo.spent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spent.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}