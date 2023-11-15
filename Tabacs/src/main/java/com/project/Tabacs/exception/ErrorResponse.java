package com.project.Tabacs.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private Integer code;
}
