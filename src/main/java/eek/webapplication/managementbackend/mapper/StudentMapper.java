//Imortant Note to self: This class is like a translator between two types of objects: Student and StudentDto. 
//It helps convert (map) information from one type to another.
package eek.webapplication.managementbackend.mapper;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;

// A class to help convert (map) information between two types: Student and StudentDto
public class StudentMapper {

    // Method to convert a Student object to a StudentDto object
    public static StudentDto mapToStudentDto(Student student) {
        // Create a new StudentDto using information from the provided Student object
        return new StudentDto(
                student.getId(),          // Copy the ID
                student.getFirstName(),   // Copy the first name
                student.getLastName(),    // Copy the last name
                student.getEmail()        // Copy the email
        );
    }

    // Method to convert a StudentDto object to a Student object
    public static Student mapToStudent(StudentDto studentDto) {
        // Create a new Student using information from the provided StudentDto object
        return new Student(
                studentDto.getId(),        // Copy the ID
                studentDto.getFirstName(), // Copy the first name
                studentDto.getLastName(),  // Copy the last name
                studentDto.getEmail()      // Copy the email
        );
    }
}
