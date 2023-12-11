package org.uz.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.uz.model.Response.ResponseModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RuntimeException{

    private ResponseModel responseModel;
    public  NotFoundException(String message){
         super(message);
    }

    public ResponseModel getException(String code, String message){
        this.responseModel.setCode(code);
        this.responseModel.setMessage(message);
        return responseModel;
    }


}
