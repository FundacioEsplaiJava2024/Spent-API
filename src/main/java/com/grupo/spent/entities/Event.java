package com.grupo.spent.entities;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, name="title")
    private String title;

    @Column(nullable = false, name="date")
    private Date date;

    @Column(nullable = false, name="startTime")
    private LocalTime startTime;

    @Column(nullable = true, name="endTime")
    private LocalTime endTime;

    @Column(nullable = true, name="numParticipants")
    private Integer numParticipants;

    @Column(nullable = false, name="adress")
    private String adress;
}
