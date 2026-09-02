package com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMemberById {

    private final MemberRepository memberRepository;

    public Member execute(String id) {
        return this.memberRepository.getMemberById(id).orElseThrow(() -> new ResourceNotFoundException("Not found member with id " + id));
    }

}
