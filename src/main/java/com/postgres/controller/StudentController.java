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
    public List<StudentDto> getAllStudents(
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize,
            @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir
    ){
        List<StudentDto> dtos = studentService.getAllStudents(pageNo, pageSize, sortBy, sortDir);
        return dtos;
    }

    @GetMapping("/id")
    public ResponseEntity<StudentDto> getStudentById(@RequestParam long id){
        StudentDto dto = studentService.getStudentById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
