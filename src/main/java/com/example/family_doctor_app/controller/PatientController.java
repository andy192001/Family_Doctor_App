package com.example.family_doctor_app.controller;

import com.example.family_doctor_app.model.Patient;
import com.example.family_doctor_app.model.dto.PatientInputDto;
import com.example.family_doctor_app.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAll();
    }

    @PostMapping
    public Patient addPatient(@RequestBody PatientInputDto command){
        return patientService.addPatient(command);
    }
}
