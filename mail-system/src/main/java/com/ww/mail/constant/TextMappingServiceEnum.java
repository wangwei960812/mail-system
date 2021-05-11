package com.ww.mail.constant;

public enum TextMappingServiceEnum {
    TEMPLATE_MSG("模板测试","templateMsgServiceImpl")
    ;

    private String text;

    private String beanName;

    TextMappingServiceEnum(String text, String beanName) {
        this.text = text;
        this.beanName = beanName;
    }

    public String getText() {
        return text;
    }

    public String getBeanName() {
        return beanName;
    }

    public static String getBeanNameByText(String text){
        for (TextMappingServiceEnum textMappingServiceEnum : TextMappingServiceEnum.values()) {
            if(textMappingServiceEnum.getText().equals(text)){
             return textMappingServiceEnum.getBeanName();
            }
        }
        return null;
    }
}
