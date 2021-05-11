package com.ww.mail.service.impl;

import com.ww.mail.model.dto.req.TemplateMsgDTO;
import com.ww.mail.model.dto.req.WeChatDataDTO;
import com.ww.mail.model.dto.req.WeChatTextMessageDTO;
import com.ww.mail.model.dto.res.WeChatMessageBasicReplyDTO;
import com.ww.mail.service.WeChatMessageService;
import com.ww.mail.service.WeChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TemplateMsgServiceImpl implements WeChatMessageService<WeChatTextMessageDTO,String> {

    @Resource
    private WeChatService weChatService;

    @Override
    public WeChatMessageBasicReplyDTO reply(WeChatTextMessageDTO weChatTextMessageDTO, String param) {
        TemplateMsgDTO templateMsgDTO = new TemplateMsgDTO();
        templateMsgDTO.setUrl("http://baidu.com");
        templateMsgDTO.setTemplateId("QdcJaWj9AEkjXSZ0T9SWBK3lAA40pBmn4a4iStmQZNU");
        templateMsgDTO.setTopColor("#FF0000");
        templateMsgDTO.setToUser(weChatTextMessageDTO.getFromUserName());
        Map<String,WeChatDataDTO> data = new HashMap<>();
        data.put("username",new WeChatDataDTO("username","#FF0000"));
        data.put("accounts",new WeChatDataDTO("accounts","#FF0000"));
        templateMsgDTO.setData(data);
        weChatService.sendTemplateMsg(templateMsgDTO);
        return null;
    }
}
