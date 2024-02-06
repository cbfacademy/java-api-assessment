package com.cbfacademy.apiassessment.file;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileBaseResponse {
    private int status;
    private String message;
    private Object data;
}
