package com.contactmanager.controller;

import com.contactmanager.entity.GlobalApiResponse;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 9:38 PM
 **/
public class BaseController {
    protected GlobalApiResponse successResponse(String message, Object data) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus("SUCCESS");
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }
}
