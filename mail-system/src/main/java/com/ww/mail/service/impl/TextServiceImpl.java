package com.ww.mail.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.constant.WeChatMessageType;
import com.ww.mail.model.dto.req.WeChatMessageBasicDTO;
import com.ww.mail.model.dto.req.WeChatTextMessageDTO;
import com.ww.mail.model.dto.res.WeChatMessageBasicReplyDTO;
import com.ww.mail.model.dto.res.WeChatTextMessageReplyDTO;
import com.ww.mail.service.WeChatMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/27 13:22
 * @description：文本消息服务
 */
@Slf4j
@Service
public class TextServiceImpl implements WeChatMessageService<WeChatTextMessageDTO> {
    @Override
    public WeChatMessageBasicReplyDTO reply(WeChatTextMessageDTO weChatTextMessageDTO) {
        log.info("{}", JSONObject.toJSONString(weChatTextMessageDTO));
        WeChatTextMessageReplyDTO weChatTextMessageReplyDTO = new WeChatTextMessageReplyDTO(weChatTextMessageDTO);
        weChatTextMessageReplyDTO.setCreateTime(String.valueOf(System.currentTimeMillis()));
        weChatTextMessageReplyDTO.setContent("hello,world");
        return weChatTextMessageReplyDTO;
    }
}
