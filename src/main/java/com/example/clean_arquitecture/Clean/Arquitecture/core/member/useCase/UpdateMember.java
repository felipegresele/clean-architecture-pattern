package com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateMember {

    private final MemberRepository memberRepository;

    public Member execute(String id, MemberRequest memberRequest) {
        Member member = this.memberRepository.getMemberById(id).orElseThrow(() -> new ResourceNotFoundException("Not found member with id " + id));
        MemberMapper.updateMember(member, memberRequest);

        return memberRepository.save(member);
    }

}
