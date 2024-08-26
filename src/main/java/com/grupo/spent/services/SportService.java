package com.grupo.spent.services;

import java.util.List;

import com.grupo.spent.entities.Sport;
import com.grupo.spent.exceptions.NotFoundException;

public interface SportService {
    List<Sport> getAllSports();

    Sport getSportByName(String name) throws NotFoundException;

    Sport createSport(String name, String description);
}