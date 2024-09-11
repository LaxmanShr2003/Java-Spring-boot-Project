package com.example.demo.response;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message,HttpStatus httpStatus, Object responsebody){

        Map<String,Object> response = new HashMap<>();
        response.put("message",message);
        response.put("httpStatus", httpStatus);
        response.put("data",responsebody);

        return new ResponseEntity<>(response,httpStatus);
    }

}
