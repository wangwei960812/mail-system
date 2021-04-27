package com.ww.mail.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:09
 * @description：视频消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatVideoMessageDTO {
    @XmlElement(name = "ThumbMediaId")
    private String ThumbMediaId;
}
