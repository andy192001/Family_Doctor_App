package com.example.family_doctor_app.repository;

import com.example.family_doctor_app.model.FamilyDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyDoctorRepository extends JpaRepository<FamilyDoctor, Long> {

    Optional<FamilyDoctor> findByEmail(String email);
}
