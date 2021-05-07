package com.ww.mail.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.model.dto.req.WeChatBasicDTO;
import com.ww.mail.model.dto.req.WeChatSubscribeEventDTO;
import com.ww.mail.model.dto.res.WeChatMessageBasicReplyDTO;
import com.ww.mail.model.dto.res.WeChatTextMessageReplyDTO;
import com.ww.mail.service.WeChatConvert;
import com.ww.mail.service.WeChatMessageService;
import com.ww.mail.utils.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/5/7 15:58
 * @description：微信关注事件处理类
 */
@Slf4j
@Service
public class SubscribeEventServiceImpl implements WeChatMessageService<WeChatSubscribeEventDTO,Object>, WeChatConvert {

    @Override
    public WeChatMessageBasicReplyDTO reply(WeChatSubscribeEventDTO weChatSubscribeEventDTO,Object param) {
        log.info("{}", JSONObject.toJSONString(weChatSubscribeEventDTO));
        WeChatTextMessageReplyDTO weChatTextMessageReplyDTO = new WeChatTextMessageReplyDTO(weChatSubscribeEventDTO);
        weChatTextMessageReplyDTO.setCreateTime(String.valueOf(System.currentTimeMillis()));
        weChatTextMessageReplyDTO.setContent(String.format("欢迎%s订阅",weChatSubscribeEventDTO.getFromUserName()));
        log.info("{}", JSONObject.toJSONString(weChatTextMessageReplyDTO));
        return weChatTextMessageReplyDTO;
    }

    @Override
    public WeChatBasicDTO stringToDto(String data) {
        return XMLUtil.convertXmlStrToObject(WeChatSubscribeEventDTO.class, data);
    }
}
