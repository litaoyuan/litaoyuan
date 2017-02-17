package com.example.arthur.demoqc4;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arthur on 2017/2/13.
 */

public class ResultResponse <T>{
    @SerializedName("Code")
    int code;
@SerializedName("Message")
String message;
@SerializedName("Token")
String token;

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
