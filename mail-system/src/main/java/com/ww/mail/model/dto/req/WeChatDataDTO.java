package com.ww.mail.model.dto.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatDataDTO {

    @JSONField(name = "value")
    private String value;

    @JSONField(name = "color")
    private String color;
}
