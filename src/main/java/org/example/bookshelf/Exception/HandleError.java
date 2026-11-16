package org.example.bookshelf.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class HandleError {
    public <T>ResponseEntity<T> handle(T response,HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(response);
    }
}
