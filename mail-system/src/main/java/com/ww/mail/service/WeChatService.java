package com.ww.mail.service;

import com.ww.mail.model.dto.req.TemplateMsgDTO;

public interface WeChatService {

    void sendTemplateMsg(TemplateMsgDTO templateMsgDTO);
}
