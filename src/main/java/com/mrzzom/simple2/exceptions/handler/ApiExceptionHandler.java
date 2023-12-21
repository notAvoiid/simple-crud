package com.mrzzom.simple2.exceptions.handler;

import com.mrzzom.simple2.exceptions.EntityNotFoundException;
import com.mrzzom.simple2.exceptions.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorMessage> entityNotFoundException(
            EntityNotFoundException ex, HttpServletRequest request){

        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

}
