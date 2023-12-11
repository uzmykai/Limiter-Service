package org.uz.model.Response;

import lombok.Data;

@Data
public class ResponseModel {
    private String code;
    private String message;
    private Object data;

    public ResponseModel(String code, String message){
        this.code = code;
        this.message = message;
    }
    public ResponseModel(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
