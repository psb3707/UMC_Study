package study.spring.umc_5.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreValidator.class)
public @interface ExistStore {
    String message() default "STORE_DOES_NOT_EXIST";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
