package com.cbfacademy.apiassessment.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileUtil {

    private final String JSON_FILE = "C:\\Users\\admin\\Desktop\\JAVA\\uploadfiles\\uploaded_files.json";

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

     public void validateFile(MultipartFile file) {
        // Implement file validation logic (e.g., file type, size, etc.)
        if (file.isEmpty() || !file.getContentType().startsWith("image")) {
            try {
                throw new Exception("Invalid file. Please upload an image.");
            } catch (Exception e) {
        
                // Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    
    public String saveFileToLocalDisk(MultipartFile file, String uploadsDir) throws IOException {
        Path filePath = Path.of(uploadsDir, file.getOriginalFilename());
        Files.createDirectories(filePath.getParent());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }

    public void saveFileInfoToJsonFile(List<FileModel> fileInfoList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE), fileInfoList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file info to JSON file.", e);
        }
    }

    public List<FileModel> readFileInfoFromJsonFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(JSON_FILE);
    
            if (!file.exists()) {
                return new ArrayList<>();
            }
    
            return objectMapper.readValue(file, new TypeReference<List<FileModel>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file info from JSON file.", e);
        }
    }
}
