package study.spring.umc_5.service.alarm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

@Service
@Slf4j
@Profile("local")
public class LocalAlarmService implements AlarmService {

    @Override
    public void sendInternalServerErrorNotification(Exception ex, WebRequest req) {
        log.debug("🔕 AlarmService disabled in 'local' profile – skipping notification");
    }
}
