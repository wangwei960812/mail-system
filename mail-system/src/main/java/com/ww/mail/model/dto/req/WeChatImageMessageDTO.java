package com.ww.mail.model.dto.req;/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:00
 * @description：微信图片消息
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
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:00
 * @description：微信图片消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatImageMessageDTO extends WeChatMessageBasicDTO{
    @XmlElement(name = "PicUrl")
    private String PicUrl;
    @XmlElement(name = "MediaId")
    private String MediaId;
}
