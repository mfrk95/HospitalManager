package com.matiask.hospitalmanager.rest;

import com.matiask.hospitalmanager.entity.Doctor;
import com.matiask.hospitalmanager.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hospital")
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping("/doctors")
    public List<Doctor> findAll(){
       List<Doctor> doctorList =  doctorService.findAll();
       return doctorList;
    }


    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctor(@PathVariable int doctorId ){
        Doctor doctor = doctorService.findById(doctorId);
        if(doctor == null){
            throw new RuntimeException("Doctor id: " + doctorId + " cannot be found");
        }
        return doctor;
    }


    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        doctor.setId(0);
        doctorService.save(doctor);
        return doctor;
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return doctor;
    }

    @DeleteMapping("/doctors/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId){
        doctorService.deleteById(doctorId);
        return "Doctor id: "+doctorId+ " has been deleted";
    }

}
