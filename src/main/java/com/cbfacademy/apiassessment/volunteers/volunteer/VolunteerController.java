package com.cbfacademy.apiassessment.volunteers.volunteer;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



/**
 * Handles HTTP requests related to volunteer management/ 
 */
@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {
    
    @Autowired
    private VolunteerService volunteerService;

    @PostMapping
    public ResponseEntity<Volunteer> createVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer savedVolunteer = volunteerService.createVolunteer(volunteer);
        return new ResponseEntity<>(savedVolunteer, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        List<Volunteer> volunteers = volunteerService.getAllVolunteers();
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(@PathVariable UUID id, @RequestBody Volunteer volunteerUpdate) {
        Volunteer updatedVolunteer = volunteerService.updateVolunteer(id, volunteerUpdate);
        return new ResponseEntity<>(updatedVolunteer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable UUID id) {
        volunteerService.deleteVolunteer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        
}
    


