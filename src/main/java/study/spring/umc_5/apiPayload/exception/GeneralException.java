package study.spring.umc_5.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.spring.umc_5.apiPayload.BaseErrorCode;
import study.spring.umc_5.apiPayload.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode errorCode;

    public ErrorReasonDTO getErrorReason() {
        return errorCode.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return errorCode.getReasonHttpStatus();
    }
}
