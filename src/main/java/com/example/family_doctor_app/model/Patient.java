package com.example.family_doctor_app.model;

import com.example.family_doctor_app.model.dto.PatientInputDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "family_doctor_id")
    private FamilyDoctor familyDoctor;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private PatientCard patientCard;

    public Patient(PatientInputDto command, FamilyDoctor familyDoctor){
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.email = command.getEmail();
        this.phone = command.getPhone();
        this.familyDoctor = familyDoctor;
    }

    public void setPatientCard(PatientCard patientCard){
        patientCard.setPatient(this);
        this.patientCard = patientCard;
    }
}
