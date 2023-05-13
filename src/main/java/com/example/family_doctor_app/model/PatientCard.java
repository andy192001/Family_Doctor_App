package com.example.family_doctor_app.model;

import com.example.family_doctor_app.model.dto.PatientInputDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_card")
public class PatientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_creation")
    private Date dateCreation = Date.valueOf(LocalDate.now());

    private Date birth;

    private String allergies;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public PatientCard(PatientInputDto command){
        this.birth = command.getBirth();
        this.allergies = command.getAllergies();
    }
}

