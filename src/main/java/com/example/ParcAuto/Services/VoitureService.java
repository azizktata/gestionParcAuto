package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.EmployeRequest;
import com.example.ParcAuto.DTOs.Requests.VoitureRequest;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.PortReposiotry;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private PortReposiotry portReposiotry;

    public Voiture addVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }

    public List<Voiture> getLesVoitures(){
        return voitureRepository.findAll();
    }

    public Voiture getVoiture(Long voitureId){
        return voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
    }

    public Voiture updateVoiture(Long voitureId, VoitureRequest voitureRequest){
        Voiture savedVoiture = voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        savedVoiture.setMarque(voitureRequest.getMarque());
        savedVoiture.setNumMatricule(voitureRequest.getNumMatricule());
        savedVoiture.setPort(portReposiotry.findByName(voitureRequest.getPortName()).orElseThrow(()-> new ObjectNotFoundException("port not found")));
        return voitureRepository.save(savedVoiture);
    }

    public void deleteVoiture(Long voitureId){
        voitureRepository.deleteById(voitureId);
    }
}
