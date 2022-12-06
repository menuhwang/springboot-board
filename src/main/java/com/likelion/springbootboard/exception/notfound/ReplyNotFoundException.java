package com.likelion.springbootboard.exception.notfound;

import com.likelion.springbootboard.exception.AbstractHttpErrorException;
import com.likelion.springbootboard.exception.ErrorCode;

public class ReplyNotFoundException extends AbstractHttpErrorException {
    public ReplyNotFoundException() {
        super(ErrorCode.REPLY_NOT_FOUND);
    }
}
