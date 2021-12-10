package com.iocl.dhruva2api.controlleradvice;


import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iocl.dhruva2api.payload.ApiResponse;

@ControllerAdvice
public class RestExceptionHandler {
	
    private final Map<Class<?>, HttpStatus> map;
    {
        map = new HashMap<>();
        map.put(HttpMessageNotWritableException.class, HttpStatus.UNPROCESSABLE_ENTITY);
        map.put(Exception.class, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleException(Exception exception) {
    	ApiResponse response = new ApiResponse(false, "Error occurred, please raise a ticket in solution manager/contact administrator");
        HttpStatus status = map.get(exception.getClass());
        if (status == null) {
            status = map.get(Exception.class);// By default
        }
        return new ResponseEntity<>(response, status);
    }
}