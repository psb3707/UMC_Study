package study.spring.umc_5.service.alarm;

import org.springframework.web.context.request.WebRequest;


public interface AlarmService {
    void sendInternalServerErrorNotification(Exception ex, WebRequest webRequest);
}
