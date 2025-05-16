package study.spring.umc_5.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.service.store.StoreQueryService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        return storeQueryService.isStoreExists(value);
    }
}
