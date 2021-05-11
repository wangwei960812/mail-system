package com.ww.mail.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.config.WeChatProperties;
import com.ww.mail.constant.SystemConstants;
import com.ww.mail.model.dto.req.AccessTokenReqDTO;
import com.ww.mail.model.dto.res.AccessTokenDTO;
import com.ww.mail.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private WeChatProperties weChatProperties;

    @Override
    public AccessTokenDTO getAccessToken() {
//        AccessTokenReqDTO accessTokenReqDTO = new AccessTokenReqDTO();
//        accessTokenReqDTO.setAppid(weChatProperties.getAppid());
//        accessTokenReqDTO.setGrant_type(SystemConstants.ACCESS_TOKENG_RANT_TYPE);
//        accessTokenReqDTO.setSecret(weChatProperties.getAppsecret());
//        log.info(JSONObject.toJSONString(accessTokenReqDTO));
        return restTemplate.getForObject(weChatProperties.getAssessTokenIp(),AccessTokenDTO.class,SystemConstants.ACCESS_TOKENG_RANT_TYPE,weChatProperties.getAppid(),weChatProperties.getAppsecret());
    }
}
