import com.cbfacademy.apiassessment.volunteers.volunteer.Volunteer;
import com.cbfacademy.apiassessment.volunteers.volunteer.VolunteerRepository;
import com.cbfacademy.apiassessment.volunteers.volunteer.VolunteerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class VolunteerServiceTest {

    @Mock
	private VolunteerRepository volunteerRepository;

	@InjectMocks
	private VolunteerServiceImpl volunteerService;
    
    // Test creating a volunteer with valid attributes
    @Test
    public void whenCreateVolunteerWithValidAttributes_thenVolunteerIsSaved() {
        // Given: A valid volunteer object and the repository's behavior to save it
        Volunteer newVolunteer = new Volunteer("Judas", "Iscariot", LocalDate.of (2006,06,06), "07383888454", "traitorjudas@aol.com", "Treasurer", "Risk taking", false, LocalDate.of(2012,04,28));
        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(newVolunteer);

        // When: Creating a volunteer
        Volunteer savedVolunteer = volunteerService.createVolunteer(newVolunteer);

        // Then: The saved volunteer should not be null and should match the new volunteer
        assertNotNull(savedVolunteer, "The saved volunteer should not be null");
        assertEquals(newVolunteer, savedVolunteer, "The saved volunteer should match the new volunteer");
        verify(volunteerRepository, times(1)).save(newVolunteer);
    }

    // Test creating a volunteer with invalid attributes (e.g., null name)
    @Test
    public void whenCreateVolunteerWithInvalidAttributes_thenThrowException() {
        // Given: An invalid volunteer object (e.g., with a null name)
        Volunteer invalidVolunteer = new Volunteer(null, "Caleb", LocalDate.of(2000,07,28), "07958444472", "m.caleb@gmail.com", "Event Manager", "Hospitality", true, LocalDate.of(2023,03,18));

        // When & Then: Creating an invalid volunteer should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            volunteerService.createVolunteer(invalidVolunteer);
        }, "Creating a volunteer with invalid attributes should throw IllegalArgumentException");
    } 

}
