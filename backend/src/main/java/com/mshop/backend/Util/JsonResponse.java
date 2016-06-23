package com.mshop.backend.Util;

/**
 * Created by Dell on 23/06/2016.
 */
public class JsonResponse {

    private int code;
    private String description;


    public JsonResponse() {
    }

    public JsonResponse(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
