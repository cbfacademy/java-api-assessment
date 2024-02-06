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
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Value("classpath:uploaded_files.json")
    private Resource jsonResource;

    // private final String JSON_FILE_PATH =
    // jsonResource.getFile().getAbsolutePath();

    // private final String UPLOAD_DIRECTORY = "../../../../resources/uploads/";



    private final String UPLOAD_DIRECTORY = "C:\\Users\\admin\\Desktop\\JAVA\\uploadfiles";
    private final FileUtil fileUtil;

    public FileService(FileUtil fileUtil) {

        this.fileUtil = fileUtil;
    }

    public ResponseEntity<FileBaseResponse> processUploadedFile(MultipartFile file, String userInfo) {
        FileBaseResponse fileBaseResponse = new FileBaseResponse();
        HttpStatus httpStatus;

        fileUtil.validateFile(file);

        try {
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

        return new ResponseEntity<>(fileBaseResponse, httpStatus);
    }

}
