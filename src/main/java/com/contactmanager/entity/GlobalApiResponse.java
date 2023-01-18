package com.contactmanager.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 9:39 PM
 **/
@Getter
@Setter
public class GlobalApiResponse {
    private String status;
    private String message;
    private Object data;

    public void setResponse(String message, String status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
