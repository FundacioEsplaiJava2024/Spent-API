package com.grupo.spent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spent.entities.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer>{
    Sport findSportByName(String name);
}