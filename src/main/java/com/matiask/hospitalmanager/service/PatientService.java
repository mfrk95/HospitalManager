package com.matiask.hospitalmanager.service;

import com.matiask.hospitalmanager.entity.Doctor;
import com.matiask.hospitalmanager.entity.Patient;

import java.util.List;

public interface PatientService {

    public List<Patient> findAll();

    public Patient findById(int id);

    public void save (Patient patient);

    public void deleteById(int id);


}
