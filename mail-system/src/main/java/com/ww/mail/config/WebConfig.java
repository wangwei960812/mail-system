package com.ww.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/27 15:08
 * @description：
 */
//@Configuration
//@EnableWebMvc
public class WebConfig {

    @Resource
    private RequestMappingHandlerAdapter adapter;

    @PostConstruct
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {

        List<HttpMessageConverter<?>> converters = adapter.getMessageConverters();

        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        MediaType xmlMedia = new MediaType(MediaType.TEXT_XML, Charset.forName("UTF-8"));
        supportedMediaTypes.add(xmlMedia);
        xmlConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(xmlConverter);

        adapter.setMessageConverters(converters);

        return adapter;
    }
}
