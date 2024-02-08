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


    // Retrieve all uploaded files
    @GetMapping("/all")
    public ResponseEntity<FileBaseResponse> getAllUploadedFiles() {
       return fileService.getAllUploadedFiles();

    }


    // Update uploaded file
    @PutMapping("/update")
    public ResponseEntity<FileBaseResponse> updateUploadedFile(@RequestBody FileModel updatedFile) {
       return fileService.updateUploadedFile(updatedFile);

    }



    // Delete uploaded file by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FileBaseResponse> deleteUploadedFile(@PathVariable String id) {
        return fileService.deleteUploadedFile(id);

    }


}
