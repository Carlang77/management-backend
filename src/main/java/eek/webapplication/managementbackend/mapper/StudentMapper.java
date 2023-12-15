package eek.webapplication.managementbackend.mapper;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto (Student student){

        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()


        );


    }
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()



        );


    }

}
