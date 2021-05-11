package com.ww.mail.model.dto.req;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板消息dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateMsgDTO {

    /**
     * openid
     */
    @JSONField(name = "touser")
    private String toUser;

    /**
     * 模板id
     */
    @JSONField(name = "template_id")
    private String templateId;

    @JSONField(name = "url")
    private String url;

    /**
     * 16进制颜色
     */
    @JSONField(name = "topcolor")
    private String topColor;

    @JSONField(name = "data")
    private Map<String,WeChatDataDTO> data;

    public static void main(String[] args) {
        TemplateMsgDTO templateMsgDTO = new TemplateMsgDTO();
        templateMsgDTO.setUrl("http://baidu.com");
        templateMsgDTO.setTemplateId("QdcJaWj9AEkjXSZ0T9SWBK3lAA40pBmn4a4iStmQZNU");
        templateMsgDTO.setTopColor("#FF0000");
        templateMsgDTO.setToUser("openid");
        Map<String,WeChatDataDTO> data = new HashMap<>();
        data.put("User",new WeChatDataDTO("User","1"));
        data.put("User1",new WeChatDataDTO("User1","1"));
        data.put("User2",new WeChatDataDTO("User2","1"));
        templateMsgDTO.setData(data);
        System.out.println(JSONObject.toJSONString(templateMsgDTO));
    }
}
