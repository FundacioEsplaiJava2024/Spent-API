package com.grupo.spent.services;

import java.util.List;

import com.grupo.spent.entities.Sport;

public interface SportService {
    List<Sport> getAllSports();
    Sport getSportById(String name);
    
    Sport createSport(String name, String description);
}