package com.ww.mail.model.dto.req;/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:11
 * @description：地理位置消息
 * @modified By：
 * @version: version
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author     ：黑洞里的光
 * @date       ：Created in 2021/4/26 14:11
 * @description：地理位置消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatLocationMessageDTO  extends WeChatMessageBasicDTO{
    @XmlElement(name = "Location_X")
    private String Location_X;
    @XmlElement(name = "Location_Y")
    private String Location_Y;
    @XmlElement(name = "Scale")
    private String Scale;
    @XmlElement(name = "Label")
    private String Label;
}
