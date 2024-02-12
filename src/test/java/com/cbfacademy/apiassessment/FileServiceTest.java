package com.cbfacademy.apiassessment;


import com.cbfacademy.apiassessment.file.FileBaseResponse;
import com.cbfacademy.apiassessment.file.FileModel;
import com.cbfacademy.apiassessment.file.FileService;
import com.cbfacademy.apiassessment.file.FileUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FileServiceTest {

    @Autowired
    FileService fileService;

    private FileModel testFile;

    private MultipartFile mockFile;

    private MultipartFile imageMockFile;

    private List<FileModel> testUploadedFiles = new ArrayList<>();


    @BeforeEach
    public void setUp() throws Exception {


        testFile = new FileModel(UUID.randomUUID().toString(), "testFile.txt", "/uploads/file/testfile.txt", Timestamp.from(Instant.now()).toString(), "234343", "text/plain", new FileUser(UUID.randomUUID().toString(), "Gifty"));

        mockFile = new MockMultipartFile(
                "file",
                "test.txt",
                "text/plain",
                "This is the content of the mock file".getBytes()

        );


        imageMockFile = new MockMultipartFile(
                "file",
                "test.txt",
                "image/jpeg",
                "This is the content of the mock file".getBytes()

        );

    }


    @Test
    @Description("/processUploadedFile method returns a 200 response")
    public void processUploadFile_ExpectedSuccessResponse() {
        ResponseEntity<FileBaseResponse> response = fileService.processUploadedFile(imageMockFile, "Gifty");

        assertEquals(200, response.getStatusCode().value());

    }

    @Test
    @Description("/processUploadedFile method returns a 500 response for invalid file")
    public void processUploadFile_ExpectedErrorResponse() {
        ResponseEntity<FileBaseResponse> response = fileService.processUploadedFile(mockFile, "Gifty");

        assertEquals(500, response.getStatusCode().value());

    }

    @Test
    @Description("/getAllUploadedFiles expecting a 200 response for success")
    public void getAllUploadedFiles_ExpectedSuccessResponse() {
        ResponseEntity<FileBaseResponse> response = fileService.getAllUploadedFiles();

        assertEquals(200, response.getStatusCode().value());

    }
}
