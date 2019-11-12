package com.todo.back.common;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class ResponseStatus {
    JSONObject success (int status) {
        JSONObject jObj = new JSONObject();
        try{
            jObj.put("Status","202");
        }catch (JSONException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }

        return jObj;
    }
}
