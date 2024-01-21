package com.cbfacademy.apiassessment.file;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "This is the test endpoint";
    }

    // Upload endpoint with a dynamic path parameter
    @GetMapping("/upload/{path}")
    public String handleFileUpload(@PathVariable("path") String path) {
        return String.format("This is the upload endpoint %s", path);
    }

    // Upload endpoint for handling file uploads
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("uploaderName") String uploaderName) {

        // Retrieve the content type of the uploaded file
        String fileType = file.getContentType();

        // Return a formatted response message with file details
        return String.format("File '%s' uploaded by '%s' with content type '%s'",
                file.getOriginalFilename(), uploaderName, fileType);
    }

    // Retrieve file endpoint
    @GetMapping
    public String retrieveFile() {
        return "This is the retrieve file endpoint";
    }

    // Update file endpoint
    @PutMapping
    public String updateFile() {
        return "This is the update file endpoint";
    }

    // Delete file endpoint
    @DeleteMapping
    public String removeFile() {
        return "This is the delete file endpoint";
    }
}
