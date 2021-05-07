package com.ww.mail.service.impl;

import com.ww.mail.model.dto.req.WeChatBasicDTO;
import com.ww.mail.model.dto.req.WeChatImageMessageDTO;
import com.ww.mail.model.dto.res.ImageDTO;
import com.ww.mail.model.dto.res.WeChatImageMessageReplyDTO;
import com.ww.mail.model.dto.res.WeChatMessageBasicReplyDTO;
import com.ww.mail.service.WeChatConvert;
import com.ww.mail.service.WeChatMessageService;
import com.ww.mail.utils.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/27 16:12
 * @description：图片服务
 */
@Slf4j
@Service
public class ImageServiceImpl implements WeChatMessageService<WeChatImageMessageDTO,Object> , WeChatConvert {

    @Override
    public WeChatMessageBasicReplyDTO reply(WeChatImageMessageDTO weChatImageMessageDTO,Object param) {
        WeChatImageMessageReplyDTO weChatImageMessageReplyDTO = new WeChatImageMessageReplyDTO(weChatImageMessageDTO);
        weChatImageMessageReplyDTO.setCreateTime(String.valueOf(System.currentTimeMillis()));
        weChatImageMessageReplyDTO.setImage(new ImageDTO(weChatImageMessageDTO.getMediaId()));
        return weChatImageMessageReplyDTO;
    }

    @Override
    public WeChatBasicDTO stringToDto(String data) {
        return XMLUtil.convertXmlStrToObject(WeChatImageMessageDTO.class, data);
    }
}
