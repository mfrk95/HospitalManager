package com.matiask.hospitalmanager.service;

import com.matiask.hospitalmanager.dao.DoctorRepository;
import com.matiask.hospitalmanager.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl  implements DoctorService{
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    @Override
    public Doctor findById(int id) {
        Optional<Doctor> result =  doctorRepository.findById(id);
        Doctor doctor = null;
        if(result.isPresent()){
            doctor = result.get();
        }
        else{
            throw new RuntimeException("Did not find doctor id: " + id );
        }
        return doctor;
    }

    @Override
    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(int id) {
        doctorRepository.deleteById(id);

    }
}
