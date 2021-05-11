package com.ww.mail.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.config.WeChatProperties;
import com.ww.mail.model.dto.req.TemplateMsgDTO;
import com.ww.mail.model.dto.res.AccessTokenDTO;
import com.ww.mail.service.AccessTokenService;
import com.ww.mail.service.WeChatService;
import com.ww.mail.utils.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WeChatServiceImpl implements WeChatService {

    @Resource
    private AccessTokenService accessTokenService;

    @Resource
    private WeChatProperties weChatProperties;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void sendTemplateMsg(TemplateMsgDTO templateMsgDTO) {
        log.info(JSONObject.toJSONString(templateMsgDTO));
        AccessTokenDTO accessToken = accessTokenService.getAccessToken();
        log.info(JSONObject.toJSONString(accessToken));
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("access_token",accessToken.getAccess_token());
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(weChatProperties.getSendTemplateMsgIp(), RestTemplateUtils.getJsonRequest(templateMsgDTO), null,uriVariables);
        log.info(JSONObject.toJSONString(objectResponseEntity));
    }
}
