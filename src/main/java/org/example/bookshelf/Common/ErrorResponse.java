package org.example.bookshelf.Common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp ;
    private  int status ;
    private String error ;
    private String message;
    private String path ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, List<String>> fieldErrors ;
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path, Map<String, List<String>> fieldErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors  ;
    }
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
