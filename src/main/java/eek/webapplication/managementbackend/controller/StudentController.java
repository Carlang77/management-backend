// Import necessary packages and classes
package eek.webapplication.managementbackend.controller;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;
import eek.webapplication.managementbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation to indicate that this class is a REST controller
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Inject StudentService dependency through constructor
    private StudentService studentService;

    // Handle HTTP POST requests to create a new student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        // Call the service to create a new student
        StudentDto savedStudent = studentService.createStudent(studentDto);
        // Return the created student and HTTP status code 201 (Created)
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // Handle HTTP GET requests to retrieve a student by ID
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentID) {
        // Call the service to get a student by ID
        StudentDto studentDto = studentService.getStudentById(studentID);
        // Return the retrieved student and HTTP status code 200 (OK)
        return ResponseEntity.ok(studentDto);
    }

    // Handle HTTP GET requests to retrieve all students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        // Call the service to get all students
        List<StudentDto> students = studentService.getAllStudents();
        // Return the list of students and HTTP status code 200 (OK)
        return ResponseEntity.ok(students);
    }

    // Handle HTTP PUT requests to update a student by ID
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent) {
        // Call the service to update a student by ID
        StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
        // Return the updated student and HTTP status code 200 (OK)
        return ResponseEntity.ok(studentDto);
    }

    // Handle HTTP DELETE requests to delete a student by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        // Call the service to delete a student by ID
        studentService.deleteStudent(studentId);
        // Return a success message and HTTP status code 200 (OK)
        return ResponseEntity.ok("Student Details Deleted Successfully!");
    }
}
