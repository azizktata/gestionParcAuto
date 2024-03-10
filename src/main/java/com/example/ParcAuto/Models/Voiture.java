package com.example.ParcAuto.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marque;
    private String numMatricule;

    @ManyToOne
    @JsonIgnore
    private Port port;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<OrdreMission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Maintenance> maintenanceList = new ArrayList<>();

}
