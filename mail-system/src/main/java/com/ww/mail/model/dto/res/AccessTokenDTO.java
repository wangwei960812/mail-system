package com.ww.mail.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/28 11:10
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {
    private String access_token;
    private String expires_in;
}
