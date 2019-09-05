package com.achek.exchangerates.repository.async;

import com.achek.exchangerates.repository.model.ResponseModel;

public interface CallBack {
    void callingBack(ResponseModel responseModel);
}
