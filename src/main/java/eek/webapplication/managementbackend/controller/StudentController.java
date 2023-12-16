package eek.webapplication.managementbackend.controller;


import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;
import eek.webapplication.managementbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto>createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentID){
        StudentDto studentDto = studentService.getStudentById(studentID);
        return ResponseEntity.ok(studentDto);

    }


    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }


    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student Details Deleted Successfully!");
    }



}
