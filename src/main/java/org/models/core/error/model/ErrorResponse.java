package org.models.core.error.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Getter
@Setter
public class ErrorResponse {
    Date timestamp;
    HttpStatus status;
    String error;

    public ErrorResponse(HttpStatus status, String message){
        this.status=status;
        this.error=message;
        timestamp = new Date();
    }
}
