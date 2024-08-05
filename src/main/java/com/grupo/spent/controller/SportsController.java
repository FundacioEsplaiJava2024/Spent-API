package com.grupo.spent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.entities.Sport;
import com.grupo.spent.services.SportService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sports")
@AllArgsConstructor
public class SportsController {

    @Autowired
    SportService sportsService;

    @GetMapping("")
    public ResponseEntity<?> getAllSports() {
        return ResponseEntity.status(HttpStatus.OK).body(sportsService.getAllSports());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getSportByName(@PathVariable String name) {
        Sport sport = sportsService.getSportByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(sport);

    }
}
