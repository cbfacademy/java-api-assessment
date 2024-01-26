package com.cbfacademy.apiassessment.file;

import java.io.File;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {


    private final String JSON_FILE_PATH = "../../../../resources/uploaded_files.json";

    private final String UPLOAD_DIRECTORY = "../../../../resources/uploads/";

    private final FileUtil fileUtil;

    public FileService(FileUtil fileUtil) {

        this.fileUtil = fileUtil;

    }

    public String processUploadedFile(
            MultipartFile file,
            String uploaderName,
            String userId) {

        // Your business logic or processing here
        // Variables for the uploaded file

        String contentType = file.getContentType();
        double size = file.getSize();
        String fileName = file.getOriginalFilename();
        String fileUploadId = fileUtil.generateFileId();
        String fileTimeStamp = fileUtil.fileTimeStamp();

        // For demonstration purposes, constructing a response message
        return String.format(
                "File '%s' uploaded by '%s' with content type '%s' and size %d bytes. Processed by service.",
                file, uploaderName, file.getContentType(), file.getSize());

    }

}
