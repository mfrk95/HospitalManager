package com.matiask.hospitalmanager.dao;

import com.matiask.hospitalmanager.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
