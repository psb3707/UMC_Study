package study.spring.umc_5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.umc_5.apiPayload.code.status.ErrorStatus;
import study.spring.umc_5.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }

    @Override
    public void throwDiscordException() {
        throw new IllegalArgumentException("Discord exception");
    }


}
