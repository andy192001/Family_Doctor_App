package com.example.family_doctor_app.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PatientInputDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birth;
    private String allergies;
}
