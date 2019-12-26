package com.topica.alert.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiResponse {
  private Object data;
  private String message;
  private HttpStatus status;

  public ApiResponse(HttpStatus status,String message){
    this.message = message;
    this.status = status;
  }
}
