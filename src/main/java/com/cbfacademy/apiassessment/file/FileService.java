package com.cbfacademy.apiassessment.file;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Value("classpath:uploaded_files.json")
    private Resource jsonResource;


    private final String UPLOAD_DIRECTORY = "C:\\Users\\admin\\Desktop\\JAVA\\uploadfiles";
    private final FileUtil fileUtil;

    public FileService(FileUtil fileUtil) {

        this.fileUtil = fileUtil;
    }

    public ResponseEntity<FileBaseResponse> processUploadedFile(MultipartFile file, String userInfo) {
        FileBaseResponse fileBaseResponse = new FileBaseResponse();
        HttpStatus httpStatus;



        try {
            fileUtil.validateFile(file);

            String fileName = file.getOriginalFilename();
            String filePath = fileUtil.saveFileToLocalDisk(file, UPLOAD_DIRECTORY);

            FileModel fileInfo = new FileModel();
            fileInfo.setFileName(fileName);
            fileInfo.setFilePath(filePath);
            fileInfo.setTimeStamp(LocalDateTime.now().toString());
            fileInfo.setUser(new FileUser(UUID.randomUUID().toString(), userInfo));
            fileInfo.setId(UUID.randomUUID().toString());
            fileInfo.setFileSize(String.valueOf(file.getSize()));
            fileInfo.setFileType(file.getContentType());

            List<FileModel> existingFiles = fileUtil.readFileInfoFromJsonFile();
            existingFiles.add(fileInfo);
            fileUtil.saveFileInfoToJsonFile(existingFiles);

            fileBaseResponse.setStatus(HttpStatus.OK.value());
            fileBaseResponse.setData(fileInfo);
            fileBaseResponse.setMessage("File uploaded successfully");
            httpStatus = HttpStatus.OK;
        } catch (IOException e) {


            fileBaseResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            fileBaseResponse.setData(e.getMessage());
            fileBaseResponse.setMessage("File uploaded failed");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        catch (ValidateFileException e) {


            fileBaseResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            fileBaseResponse.setData(e.getMessage());
            fileBaseResponse.setMessage("Not a valid file");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        }

        return new ResponseEntity<>(fileBaseResponse, httpStatus);
    }



    // Retrieve all uploaded files
    public ResponseEntity<FileBaseResponse> getAllUploadedFiles() {

        FileBaseResponse response = new FileBaseResponse();
        HttpStatus httpStatus;
        try{
            List<FileModel> uploadedFiles = fileUtil.readFileInfoFromJsonFile();

            response.setStatus(HttpStatus.OK.value());
            response.setMessage("All uploaded files retrieved successfully");
            response.setData(uploadedFiles);
            httpStatus = HttpStatus.OK;
        } catch (Exception e){

            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("All uploaded files failed");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);

    }


    // Get uploaded file by ID
    public ResponseEntity<FileBaseResponse> getUploadedFileById(@PathVariable String id) {
        FileBaseResponse response = new FileBaseResponse();
        HttpStatus httpStatus;
        try {
            FileModel file = fileUtil.getUploadedFileById(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Uploaded file retrieved successfully");
            response.setData(file);
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Failed to retrieve uploaded file");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }


    // Update uploaded file
    public ResponseEntity<FileBaseResponse> updateUploadedFile(FileModel updatedFile) {
        FileBaseResponse response = new FileBaseResponse();
        HttpStatus httpStatus;

        try {
            FileModel updatedFileInfo = fileUtil.updateUploadedFile(updatedFile);

            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Uploaded file updated successfully");
            response.setData(updatedFileInfo);
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Failed to update uploaded file");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);

    }


    // Delete uploaded file by ID
    public ResponseEntity<FileBaseResponse> deleteUploadedFile(String id) {

        FileBaseResponse response = new FileBaseResponse();
        HttpStatus httpStatus;

        try {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Uploaded file deleted successfully");
            httpStatus = HttpStatus.OK;
            fileUtil.deleteUploadedFile(id);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Failed to delete uploaded file");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }


        return new ResponseEntity<>(response, httpStatus);
    }

}
