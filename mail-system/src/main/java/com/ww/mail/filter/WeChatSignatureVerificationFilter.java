package com.ww.mail.filter;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/26 16:57
 * @description：微信验签过滤器
 */
@Slf4j
public class WeChatSignatureVerificationFilter extends OncePerRequestFilter {


    private final static String SIGNATURE = "signature";

    private final static String TIMESTAMP = "timestamp";

    private final static String NONCE = "nonce";

    private final static String ECHOSTR = "echostr";

    private String token;

    private String encodingAESKey;

    public void setToken(String token) {
        this.token = token;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean checked = checkSignature(httpServletRequest);
        if (checked) {
            try {
                if ("GET".equalsIgnoreCase(httpServletRequest.getMethod()) && new URI("/").equals(httpServletRequest.getRequestURI())) {
                    httpServletResponse.getWriter().write(httpServletRequest.getParameter(ECHOSTR));
                    logger.info("绑定成功");
                } else {
                    logger.info("验签成功");
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("验签失败");
        }
    }


    boolean checkSignature(HttpServletRequest httpServletRequest) {
        String signature = httpServletRequest.getParameter(SIGNATURE);
        String timestamp = httpServletRequest.getParameter(TIMESTAMP);
        String nonce = httpServletRequest.getParameter(NONCE);
        String[] arr = {token, timestamp, nonce};
        StringBuffer str = new StringBuffer();
        for (String s : arr) {
            str.append(s);
        }
        log.info("sha1散列明文：{}",str.toString());
        String sha1Str = null;
        try {
            sha1Str = SHA1.getSHA1(token,timestamp,nonce,"");
        } catch (AesException e) {
            e.printStackTrace();
        }
        log.info("signaeture:{} timstamp:{} nonce:{} sha1Str:{}", signature, timestamp, nonce, sha1Str);
        return signature.equals(sha1Str);
    }

}
