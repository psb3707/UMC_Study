package study.spring.umc_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc5Application {

    public static void main(String[] args) {
        SpringApplication.run(Umc5Application.class, args);
    }

}
