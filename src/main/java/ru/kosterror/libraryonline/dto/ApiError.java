package ru.kosterror.libraryonline.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class ApiError {

    private Date date;

    private int code;

    private String message;

    private Map<String, List<String>> validationMessages;

    public ApiError(String message, Map<String, List<String>> validationMessages) {
        this.date = new Date();
        this.code = 400;
        this.message = message;
        this.validationMessages = validationMessages;
    }

    public ApiError(int code, String message) {
        this.date = new Date();
        this.code = code;
        this.message = message;
        this.validationMessages = null;
    }
}
