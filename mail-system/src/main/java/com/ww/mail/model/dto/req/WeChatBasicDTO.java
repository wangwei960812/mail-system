package com.ww.mail.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/5/7 15:19
 * @description：微信基础dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatBasicDTO {
    @XmlElement(name = "ToUserName")
    private String ToUserName;
    @XmlElement(name = "FromUserName")
    private String FromUserName;
    @XmlElement(name = "CreateTime")
    private String CreateTime;
    @XmlElement(name = "MsgType")
    private String MsgType;
}
