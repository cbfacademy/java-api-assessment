package com.cbfacademy.apiassessment.file;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }



    // Upload Endpoints
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<FileBaseResponse> uploadFile(
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

    // Retrieve all uploaded files
    @GetMapping("/all")
    public ResponseEntity<FileBaseResponse> getAllUploadedFiles() {
        List<FileModel> uploadedFiles = fileService.getAllUploadedFiles();
        FileBaseResponse response = new FileBaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("All uploaded files retrieved successfully");
        response.setData(uploadedFiles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Update file endpoint
    @PutMapping
    public String updateFile() {
        return "This is the update file endpoint";
    }
    // Update uploaded file
    @PutMapping("/update")
    public ResponseEntity<FileBaseResponse> updateUploadedFile(@RequestBody FileModel updatedFile) {
        FileModel updatedFileInfo = fileService.updateUploadedFile(updatedFile);
        FileBaseResponse response = new FileBaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Uploaded file updated successfully");
        response.setData(updatedFileInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Delete file endpoint
    @DeleteMapping
    public String removeFile() {
        return "This is the delete file endpoint";
    }

    // Delete uploaded file by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FileBaseResponse> deleteUploadedFile(@PathVariable String id) {
        fileService.deleteUploadedFile(id);
        FileBaseResponse response = new FileBaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Uploaded file deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
