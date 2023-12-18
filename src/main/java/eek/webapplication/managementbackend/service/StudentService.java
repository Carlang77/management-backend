// This package statement indicates that the following code belongs to the 'eek.webapplication.managementbackend.service' package.
package eek.webapplication.managementbackend.service;

// Importing necessary classes. 'StudentDto' and 'List' are used in this interface.
import eek.webapplication.managementbackend.dto.StudentDto;
import java.util.List;

// This interface defines the contract for a service that manages student-related operations.
public interface StudentService {

    // Method signature for creating a new student. I take a 'StudentDto' object and return the created student.
    StudentDto createStudent(StudentDto studentDto);

    // Method signature for retrieving a student by their ID. I take the student ID and return the corresponding 'StudentDto'.
    StudentDto getStudentById(Long studentId);

    // Method signature for retrieving a list of all students. I return a list of 'StudentDto' objects.
    List<StudentDto> getAllStudents();

    // Method signature for updating a student's information. I take the student ID and an updated 'StudentDto', and return the updated student.
    StudentDto updateStudent(Long studentId, StudentDto updatedStudent);

    // Method signature for deleting a student by their ID. I take the student ID and perform the deletion.
    void deleteStudent(Long studentId);
}
