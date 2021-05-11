package com.ww.mail.config;

import com.ww.mail.constant.SystemConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/28 10:19
 * @description：微信属性
 */
@Data
@ConfigurationProperties(prefix = SystemConstants.WECHAT_PREX)
@Configuration
public class WeChatProperties {

    private String token;

    private String encodingAESKey;

    private String appid;

    private String appsecret;

    private String assessTokenIp;

    private String sendTemplateMsgIp;

}
