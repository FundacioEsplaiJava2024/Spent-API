package com.grupo.spent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spent.entities.Sport;
import com.grupo.spent.repositories.SportRepository;

@Service
public class SportServiceImpl implements SportService{
    
    @Autowired
    SportRepository sportRepository;

    @Override
    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    @Override
    public Sport getSportById(int id) {
        return sportRepository.findById(id).orElse(null);
    }

    @Override
    public Sport createSport(String name, String description) {
        Sport sport = new Sport();
        sport.setName(name);
        sport.setDescription(description);
        return sportRepository.save(sport);
    }
}
