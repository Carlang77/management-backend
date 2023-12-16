// Import necessary packages and classes
package eek.webapplication.managementbackend.entity;

// Annotations to import features from Jakarta Persistence
import jakarta.persistence.*;

// Lombok annotations to automatically generate boilerplate code
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Class definition for a 'Student'
@Getter // Lombok: Automatically generates getter methods for class fields
@Setter // Lombok: Automatically generates setter methods for class fields
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates an all-argument constructor
@Entity // Indicates that this class is an entity (will be stored in a database)
@Table(name = "students") // Specifies the name of the database table for this entity

// The actual class representing a 'Student'
public class Student {

    // ID field, uniquely identifies each student
    @Id // Indicates that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates unique IDs
    private Long id;

    // Field to store the first name of the student
    @Column(name = "first_name") // Specifies the name of the corresponding column in the database
    private String firstName;

    // Field to store the last name of the student
    @Column(name = "last_name") // Specifies the name of the corresponding column in the database
    private String lastName;

    // Field to store the email address of the student
    @Column(name = "email_id", nullable = false, unique = true) // Specifies constraints on the column
    private String email;
}
