package com.matiask.hospitalmanager.dao;

import com.matiask.hospitalmanager.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
