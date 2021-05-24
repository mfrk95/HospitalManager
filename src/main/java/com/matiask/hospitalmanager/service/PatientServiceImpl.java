package com.matiask.hospitalmanager.service;

import com.matiask.hospitalmanager.dao.PatientRepository;
import com.matiask.hospitalmanager.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }

    @Override
    public Patient findById(int id) {
        Optional<Patient> result =  patientRepository.findById(id);
        Patient patient = null;
        if(result.isPresent()) {
            patient = result.get();
        }else{
            throw new RuntimeException("Could not find patient id : " + id);
        }
        return patient;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);

    }

    @Override
    public void deleteById(int id) {
        patientRepository.deleteById(id);

    }
}
