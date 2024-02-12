package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.UUID;

import com.cbfacademy.apiassessment.volunteers.search.AdvancedSearchQuery;

import java.util.List;


public interface VolunteerService {
    Volunteer createVolunteer(Volunteer volunteer);

    Volunteer updateVolunteer(UUID id, Volunteer volunteer);

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(UUID id);

    void deleteVolunteer(UUID id);

    List<Volunteer> searchVolunteers(AdvancedSearchQuery query);
    
}


