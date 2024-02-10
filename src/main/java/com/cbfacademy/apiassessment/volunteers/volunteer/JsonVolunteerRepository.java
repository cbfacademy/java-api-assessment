package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;




@Repository
public class JsonVolunteerRepository implements VolunteerRepository {
    private final String filePath = "java-api-assessment/src/main/resources/volunteers.json";
    private Gson gson = new Gson();


}
