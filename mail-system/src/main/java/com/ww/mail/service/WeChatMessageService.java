package com.ww.mail.service;

import com.ww.mail.model.dto.res.WeChatMessageBasicReplyDTO;

public interface WeChatMessageService<T,P> {

    WeChatMessageBasicReplyDTO reply(T t,P param);
}
