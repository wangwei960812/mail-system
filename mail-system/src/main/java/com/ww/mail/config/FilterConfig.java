package com.ww.mail.config;

import com.ww.mail.filter.WeChatSignatureVerificationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 17:25
 * @description：过滤器配置
 */
@Configuration
public class FilterConfig {

    @Resource
    private WeChatProperties weChatProperties;

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        WeChatSignatureVerificationFilter weChatSignatureVerificationFilter = new WeChatSignatureVerificationFilter();
        weChatSignatureVerificationFilter.setToken(weChatProperties.getToken());
        weChatSignatureVerificationFilter.setEncodingAESKey(weChatProperties.getEncodingAESKey());
        registration.setFilter(weChatSignatureVerificationFilter);
        registration.addUrlPatterns("/*");
        registration.setName("weChatSignatureVerificationFilter");
        registration.setOrder(1);
        return registration;
    }
}
