package eek.webapplication.managementbackend.integration;

import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    // Inject the MockMvc instance for simulating HTTP requests
    @Autowired
    private MockMvc mockMvc;

    // Inject the StudentService to interact with the service layer
    @Autowired
    private StudentService studentService;

    // Define a test method for creating a student via the API endpoint
    @Test
    public void testCreateStudentIntegration() throws Exception {
        // Create a sample StudentDto for testing
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("John");
        studentDto.setLastName("Doe");
        studentDto.setEmail("john.doe@example.com");

        // Convert the StudentDto to JSON
        String studentDtoJson = "{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\" }";

        // Perform the POST request to create a student and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDtoJson))
                // Expect HTTP status code 201 (Created)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                // Expect the response JSON to have specific values
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"))
                // Print the request and response for debugging
                .andDo(print());


    }

}