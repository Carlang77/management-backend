// Note to self: This class is like the manager in charge of handling all operations related to students, such as creating, reading, updating, and deleting.


//Import necessary packages and classes
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

// Annotation to indicate that this class is a service component
@Service
@AllArgsConstructor
// Class implementing the StudentService interface to handle student-related operations
public class StudentServiceImpl implements StudentService {

    // Dependencies injected through the constructor
    private StudentRepository studentRepository;

    // Method to create a new student
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        // Convert StudentDto to Student and save in the repository
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        // Convert the saved Student back to StudentDto and return
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    // Method to get a student by ID
    @Override
    public StudentDto getStudentById(Long studentId) {
        // Find the student in the repository by ID, or throw an exception if not found
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("Student with " + studentId + " does not exist"));
        // Convert the found Student to StudentDto and return
        return StudentMapper.mapToStudentDto(student);
    }

    // Method to get all students
    @Override
    public List<StudentDto> getAllStudents() {
        // Get all students from the repository, convert each to StudentDto, and collect into a list
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

    // Method to update a student by ID
    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        // Find the student in the repository by ID, or throw an exception if not found
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the " + studentId + " does not exist")
        );
        // Update the student's information with the provided data
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        // Save the updated student in the repository
        Student updatedStudentObj = studentRepository.save(student);
        // Convert the updated Student to StudentDto and return
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    // Method to delete a student by ID
    @Override
    public void deleteStudent(Long studentId) {
        // Find the student in the repository by ID, or throw an exception if not found
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the " + studentId + " does not exist")
        );
        // Delete the student from the repository
        studentRepository.deleteById(studentId);
    }
}
