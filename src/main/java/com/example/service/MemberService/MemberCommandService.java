package com.example.service.MemberService;

import com.example.web.dto.MemberRequestDTO;
import com.example.domain.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}

