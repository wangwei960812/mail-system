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
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 14:54
 * @description：回复音乐消息
 */
@Data
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatMusicMessageReplyDTO extends WeChatMessageBasicReplyDTO{
    @XmlElement(name = "Title")
    private String Title;
    @XmlElement(name = "MediaId")
    private String MediaId;
    @XmlElement(name = "Description")
    private String Description;
    @XmlElement(name = "MusicURL")
    private String MusicURL;
    @XmlElement(name = "HQMusicUrl")
    private String HQMusicUrl;
    @XmlElement(name = "ThumbMediaId")
    private String ThumbMediaId;

    public WeChatMusicMessageReplyDTO(WeChatBasicDTO weChatBasicDTO) {
        super(weChatBasicDTO);
        super.setMsgType(WeChatMessageType.MUSIC);
    }

    public WeChatMusicMessageReplyDTO() {
        super.setMsgType(WeChatMessageType.MUSIC);
    }
}
