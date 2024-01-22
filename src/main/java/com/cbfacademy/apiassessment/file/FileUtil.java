package com.cbfacademy.apiassessment.file;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class FileUtil {

        public String generateFileId() {

        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();

        // Convert the UUID to a string
        String generatedID = randomUUID.toString();

        return generatedID;

    }

    public String fileTimeStamp(){

        // Time stamp
        LocalDateTime localDateTime = LocalDateTime.now();

        // DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the LocalDateTime using the specified formatter
        String formattedTimestamp = localDateTime.format(formatter);
        
        return formattedTimestamp;
    }
    
}
