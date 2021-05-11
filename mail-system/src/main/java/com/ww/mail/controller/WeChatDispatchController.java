package com.ww.mail.controller;

import com.ww.mail.component.SpringUtils;
import com.ww.mail.constant.WeChatMessageType;
import com.ww.mail.service.DispatchService;
import com.ww.mail.service.WeChatConvert;
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
        //获取消息类型
        String type = document.getRootElement().getChildText("MsgType");

        WeChatMessageService weChatMessageService;
        WeChatConvert weChatConvert;
        String beanName;

        //首先区分是微信事件推动还是微信普通消息
        if (WeChatMessageType.EVENT.equals(type)) {
            String event = document.getRootElement().getChildText("Event");
            if (event.contains("_")) {
                String[] worlds = event.split("_");
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < worlds.length; i++) {
                    builder.append(worlds[i].substring(0, 1).toUpperCase());
                    builder.append(worlds[i].substring(1));
                }
                event = builder.toString();
            }
            beanName = event + "Event" + "ServiceImpl";
        } else {
            beanName = type + "DispatchServiceImpl";
        }

        try {
            weChatConvert = SpringUtils.getBean(beanName, WeChatConvert.class);
            DispatchService dispatchService = SpringUtils.getBean(beanName, DispatchService.class);
            weChatMessageService = dispatchService.dispatch(weChatConvert.stringToDto(XMLUtil.doc2String(document)));
            if (weChatMessageService != null) {
                return weChatMessageService.reply(weChatConvert.stringToDto(XMLUtil.doc2String(document)), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
