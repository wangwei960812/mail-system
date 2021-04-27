package com.ww.mail.controller;

import com.ww.mail.component.SpringUtils;
import com.ww.mail.constant.WeChatMessageType;
import com.ww.mail.model.dto.req.WeChatImageMessageDTO;
import com.ww.mail.model.dto.req.WeChatMessageBasicDTO;
import com.ww.mail.model.dto.req.WeChatTextMessageDTO;
import com.ww.mail.service.WeChatMessageService;
import com.ww.mail.utils.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("/")
public class WeChatDispatchController {

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public Object dispatch(HttpServletRequest request) throws Exception {
        //1.创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(request.getInputStream());
        String type = document.getRootElement().getChildText("MsgType");

        WeChatMessageService weChatMessageService = null;
        WeChatMessageBasicDTO weChatMessageBasicDTO = null;

        //文本
        if (WeChatMessageType.TEXT.equalsIgnoreCase(type)) {
            weChatMessageService = SpringUtils.getBean("textServiceImpl", WeChatMessageService.class);
            weChatMessageBasicDTO = XMLUtil.convertXmlStrToObject(WeChatTextMessageDTO.class, XMLUtil.doc2String(document));
        }
        //图片
        if (WeChatMessageType.IMAGE.equalsIgnoreCase(type)) {
            weChatMessageService = SpringUtils.getBean("imageServiceImpl", WeChatMessageService.class);
            weChatMessageBasicDTO = XMLUtil.convertXmlStrToObject(WeChatImageMessageDTO.class, XMLUtil.doc2String(document));
        }

        if (weChatMessageService != null) {
            return weChatMessageService.reply(weChatMessageBasicDTO);
        } else {
            return "success";
        }

    }
}
