package eek.webapplication.managementbackend.controller;


import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;
import eek.webapplication.managementbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
