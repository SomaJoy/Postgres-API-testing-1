package com.postgres.service.util;

import com.postgres.entity.Student;
import com.postgres.payload.StudentDto;
import com.postgres.repository.StudentRepository;
import com.postgres.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
        Student saveStudent = studentRepository.save(student);
        StudentDto dto = mapToDto(saveStudent);
        return dto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> dtos = students.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
        return dtos;
    }

    public StudentDto mapToDto(Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setPercentage(student.getPercentage());
        return dto;
    }

    public Student mapToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPercentage(studentDto.getPercentage());
        return student;
    }
}
