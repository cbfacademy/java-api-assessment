package com.cbfacademy.apiassessment.file;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String processUploadedFile(
            MultipartFile file,
            String uploaderName,
            String userId) {

        // Your business logic or processing here
        // Variables for the uploaded file
        // The content type of the file

        String contentType = file.getContentType();

        // The Size of the file
        double size = file.getSize();

        // The Name of the file
        String fileName = file.getOriginalFilename();


        // For demonstration purposes, constructing a response message
        return String.format(
                "File '%s' uploaded by '%s' with content type '%s' and size %d bytes. Processed by service.",
                file, uploaderName, file.getContentType(), file.getSize());
    }


}
