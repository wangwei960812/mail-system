package com.ww.mail.controller;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.model.dto.req.SimpleMailMessageDTO;
import com.ww.mail.service.SendMailService;
import com.ww.model.constant.SystemErrConstant;
import com.ww.model.constant.SystemInfoConstant;
import com.ww.model.vo.CommonResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Api(value = "邮件发送接口", tags = {"邮件发送接口"})
@RestController(value = "/v1/api")
public class MailController {

    @Resource
    SendMailService sendMailService;

    @PostMapping("/mail/send/simple")
    @ApiOperation(value = "简单邮件发送接口")
    public CommonResVO sendMail(@RequestBody @Valid SimpleMailMessageDTO simpleMailMessageDTO, HttpServletRequest request, HttpServletResponse response){
        log.info("邮件发送请求信息：{}", JSONObject.toJSONString(simpleMailMessageDTO));
        try{
            sendMailService.send(simpleMailMessageDTO);
        }catch (Exception e){
            log.error("邮件发送请求:{} 失败：{}",request.getRequestURL(),e);
            e.printStackTrace();
            return CommonResVO.error(SystemErrConstant.MAIL_SEND_FAIL);
        }
        log.info("邮件发送请求:{} 成功",request.getRequestURL());
        return CommonResVO.success(SystemInfoConstant.MAIL_SEND_SUCC);
    }
}
