package com.example.family_doctor_app.service;

import com.example.family_doctor_app.model.Attendance;
import com.example.family_doctor_app.model.PatientCard;
import com.example.family_doctor_app.model.dto.AttendanceInputDto;
import com.example.family_doctor_app.repository.AttendanceRepository;
import com.example.family_doctor_app.repository.PatientCardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final PatientCardRepository patientCardRepository;

    @GetMapping
    public List<Attendance> getAll(PageRequest pageRequest){
        Page<Attendance> page = attendanceRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Transactional
    public Attendance addAttendance(AttendanceInputDto command){
        PatientCard patientCard = patientCardRepository.findById(command.getPatientCardId()).get();

        return new Attendance(command, patientCard);
    }


}
