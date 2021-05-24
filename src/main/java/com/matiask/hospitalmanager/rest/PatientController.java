package com.matiask.hospitalmanager.rest;

import com.matiask.hospitalmanager.entity.Patient;
import com.matiask.hospitalmanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")

public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/patients/{patientId}")
    public Patient getPatient(@PathVariable int patientId){
        Patient patient =  patientService.findById(patientId);
        if(patient == null){
            throw new RuntimeException("Patient id: "+patientId+ " cannot be found");
        }
        return patient;
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient){
        patient.setId(0);
        patientService.save(patient);
        return patient;
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient){
        patientService.save(patient);
        return patient;
    }

    @DeleteMapping("/patients/{patientId}")
    public String deletePatient(@PathVariable int patientId){
        patientService.deleteById(patientId);
        return "Patient id: " + patientId + " has been deleted";
    }


}
