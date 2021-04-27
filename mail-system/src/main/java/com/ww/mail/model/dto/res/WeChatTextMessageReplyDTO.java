package com.ww.mail.model.dto.res;

import com.ww.mail.model.dto.req.WeChatMessageBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复文本消息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatTextMessageReplyDTO extends WeChatMessageBasicReplyDTO{
    @XmlElement(name = "Content")
    private String Content;

    public WeChatTextMessageReplyDTO(WeChatMessageBasicDTO weChatMessageBasicDTO) {
        super(weChatMessageBasicDTO);
    }
}
