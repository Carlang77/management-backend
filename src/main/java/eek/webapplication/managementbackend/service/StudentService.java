package eek.webapplication.managementbackend.service;

import eek.webapplication.managementbackend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);


    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();
}


