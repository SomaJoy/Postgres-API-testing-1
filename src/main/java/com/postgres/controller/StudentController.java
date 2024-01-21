package com.postgres.controller;

import com.postgres.entity.Student;
import com.postgres.payload.StudentDto;
import com.postgres.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto dtos = studentService.createStudent(studentDto);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        List<StudentDto> dtos = studentService.getAllStudents();
        return dtos;
    }
}
