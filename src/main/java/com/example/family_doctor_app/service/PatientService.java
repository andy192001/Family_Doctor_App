package com.example.family_doctor_app.service;

import com.example.family_doctor_app.model.FamilyDoctor;
import com.example.family_doctor_app.model.Patient;
import com.example.family_doctor_app.model.PatientCard;
import com.example.family_doctor_app.model.dto.PatientInputDto;
import com.example.family_doctor_app.repository.FamilyDoctorRepository;
import com.example.family_doctor_app.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final FamilyDoctorRepository familyDoctorRepository;

    private Optional<FamilyDoctor> getCurrFamilyDoctor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FamilyDoctor familyDoctor = (FamilyDoctor) authentication.getPrincipal();
        return familyDoctorRepository.findByEmail(familyDoctor.getEmail());
    }

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    public Patient addPatient(PatientInputDto command){
        FamilyDoctor familyDoctor = getCurrFamilyDoctor().get();

        Patient patient = new Patient(command, familyDoctor);
        PatientCard patientCard = new PatientCard(command);
        patient.setPatientCard(patientCard);
        return patientRepository.save(patient);
    }
}
