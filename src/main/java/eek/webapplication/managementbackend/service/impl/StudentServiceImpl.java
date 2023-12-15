package eek.webapplication.managementbackend.service.impl;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;
import eek.webapplication.managementbackend.mapper.StudentMapper;
import eek.webapplication.managementbackend.repository.StudentRepository;
import eek.webapplication.managementbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }
}
