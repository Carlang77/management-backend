package eek.webapplication.managementbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eek.webapplication.managementbackend.dto.StudentDto;
import eek.webapplication.managementbackend.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void testCreateStudent() throws Exception {
        // Create a sample StudentDto for testing
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setFirstName("John");
        studentDto.setLastName("Doe");
        studentDto.setEmail("john.doe@example.com");

        // Convert the StudentDto to JSON
        String studentDtoJson = new ObjectMapper().writeValueAsString(studentDto);

        // Mock the service response
        when(studentService.createStudent(any(StudentDto.class))).thenReturn(studentDto);

        // Perform the POST request and validate the response
        ResultActions result = mockMvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDtoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));

        // Verify that the service method was called
        verify(studentService, times(1)).createStudent(any(StudentDto.class));
    }

    // Add similar tests for other methods (getStudentById, getAllStudents, updateStudent, deleteStudent)
}
