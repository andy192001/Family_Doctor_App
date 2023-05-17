package com.example.family_doctor_app.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceInputDto {
    private String diagnose;
    private String symptoms;
    private Long patientCardId;
}
