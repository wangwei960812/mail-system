package com.ww.mail.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/27 11:11
 * @description：微信消息基础dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatMessageBasicDTO extends WeChatBasicDTO{
    @XmlElement(name = "MsgId")
    private String MsgId;
}
