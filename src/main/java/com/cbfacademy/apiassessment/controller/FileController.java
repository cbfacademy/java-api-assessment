package com.cbfacademy.apiassessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@RestController
public class FileController {

    @GetMapping("/test")
    public String test(){
        return "This is the test endpoint";

    }

    @GetMapping("/upload/{path}")
    public String handleFileUpload(@PathVariable("path") String path){
        return String.format("This is the upload endpoint %s", path) ;
    }
}
