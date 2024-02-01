package com.cbfacademy.apiassessment.file;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

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


    // Upload Endpoints
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public FileModel uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("uploaderName") String uploaderName

          ) {

        // Delegate processing to the service layer
        return fileService.processUploadedFile(file, uploaderName);
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
