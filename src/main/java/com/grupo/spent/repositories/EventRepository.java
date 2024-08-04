package com.grupo.spent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spent.entities.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
