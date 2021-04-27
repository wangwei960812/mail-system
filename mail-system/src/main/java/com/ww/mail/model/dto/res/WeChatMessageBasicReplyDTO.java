package com.ww.mail.model.dto.res;

import com.ww.mail.model.dto.req.WeChatMessageBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/27 11:28
 * @description：微信回复消息基础类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatMessageBasicReplyDTO {
    @XmlElement(name = "ToUserName")
    private String ToUserName;
    @XmlElement(name = "FromUserName")
    private String FromUserName;
    @XmlElement(name = "CreateTime")
    private String CreateTime;
    @XmlElement(name = "MsgType")
    private String MsgType;

    public WeChatMessageBasicReplyDTO(WeChatMessageBasicDTO weChatMessageBasicDTO) {
        this.FromUserName = weChatMessageBasicDTO.getToUserName();
        this.ToUserName = weChatMessageBasicDTO.getFromUserName();
        this.MsgType = weChatMessageBasicDTO.getMsgType();
    }

}
