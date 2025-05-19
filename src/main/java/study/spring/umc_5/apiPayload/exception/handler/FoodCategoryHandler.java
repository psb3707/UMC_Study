package study.spring.umc_5.apiPayload.exception.handler;

import study.spring.umc_5.apiPayload.BaseErrorCode;
import study.spring.umc_5.apiPayload.code.status.ErrorStatus;
import study.spring.umc_5.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
