package study.spring.umc_5.service.alarm;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Profile("!local")
public class ProdAlarmService implements AlarmService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${alarm.discord.webhook-url}")
    private String DISCORD_URL;

    @Value("${alarm.slack.webhook-url}")
    private String SLACK_URL;

    @Override
    public void sendInternalServerErrorNotification(Exception ex, WebRequest webRequest) {

        String message = formatErrorMessage(ex, webRequest);

        Map<String, String> content = Map.of("content", message);

        restTemplate.postForEntity(DISCORD_URL, content, String.class);
        restTemplate.postForEntity(SLACK_URL,   Map.of("text",message), String.class);
    }

    public String formatErrorMessage(Exception ex, WebRequest webRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("🚨 **서버 에러 발생!**\n");
        sb.append("**시간:** ").append(LocalDateTime.now()).append("\n");

        // WebRequest를 HttpServletRequest로 변환
        if (webRequest instanceof ServletWebRequest servletWebRequest) {
            HttpServletRequest request = servletWebRequest.getRequest();

            sb.append("**요청 URL:** ").append(request.getRequestURL()).append("\n");
            sb.append("**HTTP Method:** ").append(request.getMethod()).append("\n");
            sb.append("**IP:** ").append(request.getRemoteAddr()).append("\n");
        } else {
            // 만약 서블릿 환경이 아닐 경우 (포틀릿 등) fallback 처리
            sb.append("**요청 정보:** 서블릿 환경이 아님\n");
        }

        sb.append("**에러 메시지:** ").append(ex.getMessage()).append("\n");

        // 스택트레이스 앞부분만 출력 (1000글자 제한 등)
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String stackTrace = sw.toString();
        sb.append("**스택트레이스:**\n```\n")
                .append(stackTrace.substring(0, Math.min(stackTrace.length(), 1000)))
                .append("\n```");

        return sb.toString();
    }
}
