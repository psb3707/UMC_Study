package study.spring.umc_5.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;
import study.spring.umc_5.service.memberMission.MemberMissionService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MissionValidator implements ConstraintValidator<AlreadyChanllenging, Long> {

    private final MemberMissionService memberMissionService;

    @Override
    public void initialize(AlreadyChanllenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        return memberMissionService.isChallengingMission(value);
    }
}
