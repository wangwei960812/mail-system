package com.ww.mail.service.impl;

import com.ww.mail.component.SpringUtils;
import com.ww.mail.constant.TextMappingServiceEnum;
import com.ww.mail.model.dto.req.WeChatBasicDTO;
import com.ww.mail.model.dto.req.WeChatTextMessageDTO;
import com.ww.mail.service.DispatchService;
import com.ww.mail.service.WeChatConvert;
import com.ww.mail.service.WeChatMessageService;
import com.ww.mail.utils.XMLUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TextDispatchServiceImpl implements DispatchService<WeChatTextMessageDTO>,WeChatConvert {

    @Resource
    private DefaultTextServiceImpl defaultTextService;

    @Override
    public WeChatMessageService dispatch(WeChatTextMessageDTO weChatTextMessageDTO) {
        WeChatMessageService weChatMessageService;
        String name = TextMappingServiceEnum.getBeanNameByText(weChatTextMessageDTO.getContent());
        if (!StringUtils.isEmpty(name)) {
            try {
                weChatMessageService = SpringUtils.getBean(name, WeChatMessageService.class);
            } catch (Exception e) {
                e.printStackTrace();
                return defaultTextService;
            }
            return weChatMessageService;
        }
        return defaultTextService;
    }



    @Override
    public WeChatBasicDTO stringToDto(String data) {
        return XMLUtil.convertXmlStrToObject(WeChatTextMessageDTO.class, data);
    }
}
