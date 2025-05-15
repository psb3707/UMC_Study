package study.spring.umc_5.senior;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.umc_5.service.alarm.LocalAlarmService;

@SpringBootTest
public class AlarmServiceTest {
    
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    
    
    @DisplayName("")
    @Test
    void getBean(){
        
        //given
        LocalAlarmService alarmService = applicationContext.getBean(LocalAlarmService.class);

        System.out.println("alarmService.getClass() = " + alarmService.getClass());


        //when
        
        //then
    }
}
