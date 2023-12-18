package eek.webapplication.managementbackend.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Layer should help TOs are objects that carry data between your application layers,
// especially between the service layer and the controller layer. Encapsulates the data that needs to be transferred.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
