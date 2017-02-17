package com.example.arthur.demoqc4.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by arthur on 2017/2/13.
 */

public class ReturnDataResponse<T> {
    @SerializedName("Code")
    int code;
    @SerializedName("Message")
    String message;
    @SerializedName("Token")
    String token;
    T Data;

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public T getData() {
        return Data;
    }

    public void setData(T data) {
        this.Data = data;
    }
}
