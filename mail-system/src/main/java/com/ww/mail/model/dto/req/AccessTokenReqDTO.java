package com.ww.mail.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/28 11:18
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenReqDTO {

    private String grant_type;

    private String appid;

    private String secret;
}
