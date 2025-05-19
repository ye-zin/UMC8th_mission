package com.example.apiPayload.exception.handler;

import com.example.apiPayload.code.status.ErrorStatus;
import com.example.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
