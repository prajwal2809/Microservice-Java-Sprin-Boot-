package com.lcwd.user.service.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    public ApiResponse() {
    }

    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setSucess(boolean success) {
        this.success = success;
    }


    public void setStatus(HttpStatus httpStatus) {
        this.status = status;
    }
}
