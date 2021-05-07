package com.ww.mail.schedule;

import com.ww.mail.config.WeChatProperties;
import com.ww.mail.constant.SystemConstants;
import com.ww.mail.domain.db.entities.TAccessToken;
import com.ww.mail.domain.db.entities.TAccessTokenExample;
import com.ww.mail.domain.db.mapper.TAccessTokenMapper;
import com.ww.mail.model.dto.req.AccessTokenReqDTO;
import com.ww.mail.model.dto.res.AccessTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/4/28 11:01
 * @description：定时刷新assess_token
 */
@Slf4j
//@Component
public class RefreshAccessTokenTask {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private WeChatProperties weChatProperties;

    @Resource
    private TAccessTokenMapper tAccessTokenMapper;

    @Scheduled(cron = "*/15 * * * * ?")
    public void refresh() {

        AccessTokenReqDTO accessTokenReqDTO = new AccessTokenReqDTO();
        accessTokenReqDTO.setAppid(weChatProperties.getAppid());
        accessTokenReqDTO.setGrant_type(SystemConstants.ACCESS_TOKENG_RANT_TYPE);
        accessTokenReqDTO.setSecret(weChatProperties.getAppsecret());
        AccessTokenDTO accessTokenDTO = restTemplate.getForObject(weChatProperties.getAssessTokenIp(), AccessTokenDTO.class, accessTokenReqDTO);

        TAccessTokenExample tAccessTokenExample = new TAccessTokenExample();
        TAccessTokenExample.Criteria criteria = tAccessTokenExample.createCriteria();
        criteria.andAccessTokenEqualTo(accessTokenDTO.getAccess_token());
        List<TAccessToken> tAccessTokens = tAccessTokenMapper.selectByExample(tAccessTokenExample);
        if (tAccessTokens.size() > 0) {
            log.info("access_token:{} is valid", accessTokenDTO.getAccess_token());
        } else {
            //删除之前的token

            //新增一个token
            TAccessToken tAccessToken = new TAccessToken();
            tAccessToken.setAccessToken(accessTokenDTO.getAccess_token());
            tAccessToken.setIsDelete("0");
            tAccessToken.setExpiresIn(accessTokenDTO.getExpires_in());
            tAccessToken.setCreateDate(new Date());
            tAccessToken.setModifyDate(new Date());
            tAccessTokenMapper.insert(tAccessToken);
        }
    }
}
