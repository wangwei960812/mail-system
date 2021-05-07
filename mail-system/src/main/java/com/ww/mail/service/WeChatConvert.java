package com.ww.mail.service;

import com.ww.mail.model.dto.req.WeChatBasicDTO;

public interface WeChatConvert {

    WeChatBasicDTO stringToDto(String data);
}
