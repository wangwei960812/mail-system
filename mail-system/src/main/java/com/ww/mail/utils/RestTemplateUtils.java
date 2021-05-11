package com.ww.mail.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class RestTemplateUtils {

    public static HttpEntity getJsonRequest(Object o){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(JSONObject.toJSONString(o), headers);
    }
}
