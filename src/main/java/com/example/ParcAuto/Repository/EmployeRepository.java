package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
