package com.example.family_doctor_app.controller;

import com.example.family_doctor_app.model.Attendance;
import com.example.family_doctor_app.model.dto.AttendanceInputDto;
import com.example.family_doctor_app.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendances(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "5") Integer size
    ){
        return attendanceService.getAll(PageRequest.of(page, size));
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody AttendanceInputDto command){
        return attendanceService.addAttendance(command);
    }
}
