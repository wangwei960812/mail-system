package com.ww.mail.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/5/7 15:20
 * @description：微信事件基础dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatEventBasicDTO extends WeChatBasicDTO {
    @XmlElement(name = "Event")
    private String Event;
}
