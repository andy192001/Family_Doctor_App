package com.example.family_doctor_app.repository;

import com.example.family_doctor_app.model.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {

}
