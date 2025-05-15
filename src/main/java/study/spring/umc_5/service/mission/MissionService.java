package study.spring.umc_5.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Mission;
import study.spring.umc_5.domain.Region;
import study.spring.umc_5.domain.Store;
import study.spring.umc_5.domain.mapping.MemberMission;
import study.spring.umc_5.repository.RegionRepository;
import study.spring.umc_5.repository.member.MemberRepository;
import study.spring.umc_5.repository.membermission.MemberMissionRepository;
import study.spring.umc_5.repository.mission.MissionRepository;
import study.spring.umc_5.repository.store.StoreRepository;
import study.spring.umc_5.web.dto.MissionCreateDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long addMission(MissionCreateDto missionCreateDto, Long storeId){

        Store store = storeRepository.findById(storeId)
                .orElseThrow();

        Region region = regionRepository.findById(store.getRegion().getId())
                .orElseThrow();

        Mission mission = MissionCreateDto.toMission(missionCreateDto, region, store);

        return missionRepository.save(mission).getId();
    }

}
