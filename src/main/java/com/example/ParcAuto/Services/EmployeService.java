package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.LoginRequest;
import com.example.ParcAuto.DTOs.Requests.LoginResponse;
import com.example.ParcAuto.DTOs.Requests.RegisterRequest;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;


    public Employe addEmploye(RegisterRequest request){
        Employe employe = Employe.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .fonction(request.getFonction())
                .password(request.getPassword())
                .username(request.getUsername())
                .build();
        return employeRepository.save(employe);
    }
    public long getEmployeCount(){
        return employeRepository.count();
    }

    public List<Employe> getAll(){
        return employeRepository.findAll();
    }

    public Employe getEmploye(Long employeId){
        return employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
    }
    public LoginResponse login(LoginRequest request){
        Employe employe = employeRepository.findByUsername(request.getUsername()).orElseThrow(()-> new ObjectNotFoundException("user not found"));
        if (employe != null){
            if(!employe.getPassword().equals(request.getPassword())){
                throw new ObjectNotFoundException("Incorrect password");
            }
        }
        return LoginResponse.builder()
                .id(String.valueOf(employe.getId()))
                .username(request.getUsername())
                .build();
    }

    public Employe updateEmploye(Long employeId, RegisterRequest registerRequest){
        Employe savedEmploye = employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
        savedEmploye.setFirstName(registerRequest.getFirstName());
        savedEmploye.setLastName(registerRequest.getLastName());
        savedEmploye.setEmail(registerRequest.getEmail());
        savedEmploye.setFonction(registerRequest.getFonction());
        savedEmploye.setPassword(registerRequest.getPassword());
        return employeRepository.save(savedEmploye);
    }

    public void deleteEmploye(Long employeId){
       employeRepository.deleteById(employeId);
    }

    //my reports
    //my missions

}
