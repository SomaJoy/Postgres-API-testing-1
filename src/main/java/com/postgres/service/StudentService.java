package com.postgres.service;

import com.postgres.payload.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents(int pageNo, int pageSize, String sortBy, String sortDir);

    StudentDto getStudentById(long id);
}
