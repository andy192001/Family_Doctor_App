package com.example.family_doctor_app.service;

import com.example.family_doctor_app.repository.PatientCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientCardService {

    private final PatientCardRepository patientCardRepository;
}
