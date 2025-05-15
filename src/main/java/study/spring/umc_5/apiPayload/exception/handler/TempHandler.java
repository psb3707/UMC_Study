package study.spring.umc_5.apiPayload.exception.handler;

import study.spring.umc_5.apiPayload.BaseErrorCode;
import study.spring.umc_5.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
