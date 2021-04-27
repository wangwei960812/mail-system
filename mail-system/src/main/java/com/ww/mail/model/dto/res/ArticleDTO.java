package com.ww.mail.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 15:54
 * @description：图文消息信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "item")
public class ArticleDTO {
    @XmlElement(name = "Title")
    private String Title;
    @XmlElement(name = "Description")
    private String Description;
    @XmlElement(name = "PicUrl")
    private String PicUrl;
    @XmlElement(name = "Url")
    private String Url;
}
