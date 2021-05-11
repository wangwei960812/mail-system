package com.ww.mail.service;

public interface DispatchService<T> {

    WeChatMessageService dispatch(T t);

}
