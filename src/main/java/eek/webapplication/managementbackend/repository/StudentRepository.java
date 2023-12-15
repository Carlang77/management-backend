package eek.webapplication.managementbackend.repository;

import eek.webapplication.managementbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long>  {

}
