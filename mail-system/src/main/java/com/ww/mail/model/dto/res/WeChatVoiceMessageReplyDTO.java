package com.ww.mail.model.dto.res;

import com.ww.mail.constant.WeChatMessageType;
import com.ww.mail.model.dto.req.WeChatBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author     ：黑洞里的光
 * @date       ：Created in 2021/4/26 14:50
 * @description：回复语音消息
 */
@Data
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatVoiceMessageReplyDTO extends WeChatMessageBasicReplyDTO{
    @XmlElement(name = "MediaId")
    private String MediaId;

    public WeChatVoiceMessageReplyDTO(WeChatBasicDTO weChatBasicDTO) {
        super(weChatBasicDTO);
        super.setMsgType(WeChatMessageType.VOICE);
    }

    public WeChatVoiceMessageReplyDTO() {
        super.setMsgType(WeChatMessageType.VOICE);
    }
}
