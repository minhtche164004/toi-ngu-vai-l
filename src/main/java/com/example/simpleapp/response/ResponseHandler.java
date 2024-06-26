package com.example.simpleapp.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object resposneObject
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", resposneObject);
        return new ResponseEntity<>(response, httpStatus);
    }
}
