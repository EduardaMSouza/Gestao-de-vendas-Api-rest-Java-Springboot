package com.souzamanagement.salesmanagement.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String message;

    public void setMessage(String message) {
        if(this.message == null) {
            this.message = message;
        }else{
            this.message = this.message + ", " + message;
        }
    }
}
