package eek.webapplication.managementbackend.service.impl;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;
import eek.webapplication.managementbackend.exception.ResourceNotFoundException;
import eek.webapplication.managementbackend.mapper.StudentMapper;
import eek.webapplication.managementbackend.repository.StudentRepository;
import eek.webapplication.managementbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("Student with " + studentId + " does not exist"));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List <Student> students = studentRepository.findAll();
        return students.stream().map((student) ->StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {

Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the " + studentId + " does not exist")
);
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        Student updatedStudentObj =  studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the " + studentId + " does not exist")
        );

        studentRepository.deleteById(studentId);
    }
}
