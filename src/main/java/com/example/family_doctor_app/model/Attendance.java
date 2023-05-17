package com.example.family_doctor_app.model;

import com.example.family_doctor_app.model.dto.AttendanceInputDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_creation")
    private Date dateCreation = Date.valueOf(LocalDate.now());

    private String diagnose;

    private String symptoms;

    @ManyToOne
    @JoinColumn(name = "patient_card_id")
    private PatientCard patientCard;

    public Attendance(AttendanceInputDto command, PatientCard patientCard){
        this.diagnose = command.getDiagnose();
        this.symptoms = command.getSymptoms();
        this.patientCard = patientCard;
    }
}
