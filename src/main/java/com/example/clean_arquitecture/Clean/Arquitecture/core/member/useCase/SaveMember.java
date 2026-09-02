package com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMember {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member execute(MemberRequest request) {
        Member member = this.memberMapper.toRequestToEntity(request);
        this.memberRepository.save(member);
        return member;
    }

}
