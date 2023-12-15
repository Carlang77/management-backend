package eek.webapplication.managementbackend.service;

import eek.webapplication.managementbackend.dto.StudentDto;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);


    StudentDto getStudentById(Long studentId);
}


