package org.uz.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.uz.model.Response.ResponseModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConflictException extends RuntimeException {

    private ResponseModel responseModel;
    public  ConflictException(String message){
        super(message);
    }

    public ResponseModel getException(String code, String message){
        this.responseModel.setCode(code);
        this.responseModel.setMessage(message);
        return responseModel;
    }
}
