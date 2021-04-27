package com.ww.mail.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 */
@Slf4j
public class Validator {

    /**
     * Email Regex java
     */
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    /**
     * 校验email格式
     *
     * @param email
     * @return
     */
    public static boolean validateEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            log.error("校验的邮箱不能为空！");
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            log.error("输入邮箱格式校验失败：{}", email);
            return false;
        }
        return true;
    }
}
