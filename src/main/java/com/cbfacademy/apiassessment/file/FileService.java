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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Value("classpath:uploaded_files.json")
    private Resource jsonResource;

    // private final String JSON_FILE_PATH =
    // jsonResource.getFile().getAbsolutePath();

    // private final String UPLOAD_DIRECTORY = "../../../../resources/uploads/";

    @Value("classpath:uploads")
    private Resource fileUploadsResource;

    private final FileUtil fileUtil;

    public FileService(@Value("classpath:uploads") Resource fileUploadsResource, FileUtil fileUtil) {
        this.fileUploadsResource = fileUploadsResource;
        this.fileUtil = fileUtil;
    }

    public FileModel processUploadedFile(MultipartFile file, String userInfo) {

        fileUtil.validateFile(file);

        try {
            String fileName = file.getOriginalFilename();
            String filePath = fileUtil.saveFileToLocalDisk(file, fileUploadsResource);

            FileModel fileInfo = new FileModel();
            fileInfo.setFileName(fileName);
            fileInfo.setFilePath(filePath);
            fileInfo.setTimeStamp(LocalDateTime.now().toString());
            fileInfo.setUser(new FileUser(UUID.randomUUID().toString(), userInfo));

            List<FileModel> existingFiles = fileUtil.readFileInfoFromJsonFile();
            existingFiles.add(fileInfo);
            fileUtil.saveFileInfoToJsonFile(existingFiles);

            return fileInfo;

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file.", e);
        }
    }

}
