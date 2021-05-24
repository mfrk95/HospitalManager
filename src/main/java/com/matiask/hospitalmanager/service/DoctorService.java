package com.matiask.hospitalmanager.service;

import com.matiask.hospitalmanager.entity.Doctor;

import java.util.List;

public interface DoctorService {

    public List<Doctor> findAll();

    public Doctor findById(int id);

    public void save (Doctor doctor);

    public void deleteById(int id);


}
