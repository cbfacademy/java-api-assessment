package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.UUID;
import java.util.List;


public interface VolunteerService {
    Volunteer createVolunteer(Volunteer volunteer);

    Volunteer updateVolunteer(UUID id, Volunteer volunteer);

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(UUID id);

    void deleteVolunteer(UUID id);
    
}
