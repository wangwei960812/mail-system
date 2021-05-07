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
import java.util.List;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:56
 * @description：回复图文消息
 */
@Data
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatNewsMessageReplyDTO extends WeChatMessageBasicReplyDTO{
    @XmlElement(name = "ArticleCount")
    private String ArticleCount;
    @XmlElement(name = "Articles")
    private List<ArticleDTO> Articles;

    public WeChatNewsMessageReplyDTO(WeChatBasicDTO weChatBasicDTO) {
        super(weChatBasicDTO);
        super.setMsgType(WeChatMessageType.NEWS);
    }

    public WeChatNewsMessageReplyDTO() {
        super.setMsgType(WeChatMessageType.NEWS);
    }
}
