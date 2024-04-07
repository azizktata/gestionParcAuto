package com.example.ParcAuto.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sujet;
    private String description;

    @ManyToOne
    @JsonIgnore
    private Employe employe;

    // new
    private LocalDate dateAccident;
    private String lieuxAccident;
    @ManyToOne
    @JsonIgnore
    private Voiture voiture;




}
