package com.ww.mail.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:52
 * @description：回复视频消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatVideoMessageReplyDTO extends WeChatMessageBasicReplyDTO{
    @XmlElement(name = "MediaId")
    private String MediaId;
    @XmlElement(name = "Title")
    private String Title;
    @XmlElement(name = "Description")
    private String Description;
}
