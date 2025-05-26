package com.example.apiPayload.exception.handler;

import com.example.apiPayload.BaseErrorCode;
import com.example.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
