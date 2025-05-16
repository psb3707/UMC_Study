package study.spring.umc_5.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MissionValidator.class)
public @interface AlreadyChanllenging {
    String message() default "ALREADY_CHALLENGING_MISSION";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
