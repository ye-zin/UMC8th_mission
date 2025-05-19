package com.example.service.MemberService;

import com.example.apiPayload.MemberRequestDTO;
import com.example.apiPayload.code.status.ErrorStatus;
import com.example.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.converter.MemberConverter;
import com.example.converter.MemberPreferConverter;
import com.example.domain.FoodCategory;
import com.example.domain.Member;
import com.example.domain.mapping.MemberPrefer;
import com.example.repository.FoodCategoryRepository.FoodCategoryRepository;
import com.example.repository.MemberRepository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
