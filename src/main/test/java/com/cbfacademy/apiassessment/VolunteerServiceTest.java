import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbfacademy.apiassessment.volunteers.volunteer.Volunteer;
import com.cbfacademy.apiassessment.volunteers.volunteer.VolunteerRepository;
import com.cbfacademy.apiassessment.volunteers.volunteer.VolunteerServiceImpl;


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

    // Test updating an existing volunteer with valid changes
    @Test
    public void whenUpdateExistingVolunteer_thenVolunteerIsUpdated() {
        // Given: An existing volunteer
        UUID existingVolunteerId = UUID.randomUUID();
        Volunteer existingVolunteer = new Volunteer("Elizabeth", "John", LocalDate.of(1980,01,15), "07584986718", "lizzi.john@yahoo.com", "Administrator", "Organisation", true, LocalDate.of(2023,8,15));
        existingVolunteer.setId(existingVolunteerId); // Assume setter method exists

        // And: Updated volunteer details
        Volunteer updatedVolunteer = new Volunteer("Mary", "Joseph", LocalDate.of(1981,01,15), "07584986717", "mary.joseph@ygmail.com", "Administrator", "Organisation", true, LocalDate.of(2023,8,15));
        updatedVolunteer.setId(existingVolunteerId);

        // When: Repository is set to return the existing volunteer
        when(volunteerRepository.findById(existingVolunteerId)).thenReturn(Optional.of(existingVolunteer));
        // And: Repository saves the updated volunteer
        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(updatedVolunteer);

        // Then: Update volunteer
        Volunteer result = volunteerService.updateVolunteer(existingVolunteerId, updatedVolunteer);

        // Assert: The updated volunteer is returned with correct details
        assertNotNull(result, "Updated volunteer should not be null");
        assertEquals("UpdatedFirstName", result.getFirstName(), "First name should be updated");
        assertEquals("UpdatedLastName", result.getLastName(), "Last name should be updated");

        // Verify: Repository interactions
        verify(volunteerRepository, times(1)).findById(existingVolunteerId);
        verify(volunteerRepository, times(1)).save(updatedVolunteer);
    }

    // Test updating a non-existing volunteer
    @Test
    public void whenUpdateNonExistingVolunteer_thenThrowNotFoundException() {
        // Given: A UUID for a non-existing volunteer
        UUID nonExistingVolunteerId = UUID.randomUUID();

        // And: The repository is set to return an empty Optional when findById is called
        when(volunteerRepository.findById(nonExistingVolunteerId)).thenReturn(Optional.empty());

        // When & Then: Updating a non-existing volunteer should throw VolunteerNotFoundException
        assertThrows(VolunteerNotFoundException.class, () -> {
            volunteerService.updateVolunteer(nonExistingVolunteerId, new Volunteer(/* parameters for updated volunteer */));
        }, "Attempting to update a non-existing volunteer should throw VolunteerNotFoundException");

        // Verify: The repository's findById method was called with the non-existing ID
        verify(volunteerRepository, times(1)).findById(nonExistingVolunteerId);
    }
    }
}
