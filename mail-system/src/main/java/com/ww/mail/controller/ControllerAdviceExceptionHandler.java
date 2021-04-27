package com.ww.mail.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ww.model.constant.SystemErrConstant;
import com.ww.model.vo.CommonResVO;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SignatureException;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler({ExpiredJwtException.class})
    public CommonResVO handlerJwtException(ExpiredJwtException e){
        return CommonResVO.error(SystemErrConstant.JWT_EXPIRED.getErrCode(),SystemErrConstant.JWT_EXPIRED.getDesc());
    }

    @ExceptionHandler({SignatureException.class})
    public CommonResVO handlerSignatureException(SignatureException e){
        return CommonResVO.error(SystemErrConstant.JWT_AUTH_FAIL.getErrCode(),SystemErrConstant.JWT_AUTH_FAIL.getDesc());
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public CommonResVO handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return CommonResVO.error(SystemErrConstant.METHOD_NOT_SUPPORTED.getErrCode(),SystemErrConstant.METHOD_NOT_SUPPORTED.getDesc(),e.getMethod());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResVO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors() && bindingResult.hasFieldErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            JSONObject errors = new JSONObject();
            for (FieldError fieldError : fieldErrors) {
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return CommonResVO.error(SystemErrConstant.JAVAX_VALIDATION_ERROR.getErrCode(),errors.toJSONString());
        }else{
            return CommonResVO.error(String.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @ExceptionHandler({JsonParseException.class,JsonMappingException.class})
    public CommonResVO handlerJsonException(JsonParseException e,JsonMappingException e1){
        e.printStackTrace();
        e1.printStackTrace();
        return CommonResVO.error(SystemErrConstant.JSON_PARSE_EXCEPTION);
    }

    @ExceptionHandler({Exception.class})
    public CommonResVO handlerException(Exception e){
        e.printStackTrace();
        return CommonResVO.error(SystemErrConstant.SYSTEM_EXCEPTION.getErrCode(),SystemErrConstant.SYSTEM_EXCEPTION.getDesc());
    }
}
