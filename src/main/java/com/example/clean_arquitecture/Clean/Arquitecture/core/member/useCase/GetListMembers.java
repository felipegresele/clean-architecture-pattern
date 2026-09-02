package com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetListMembers {

    private final MemberRepository memberRepository;

    public List<Member> execute() {
        return this.memberRepository.getAllMembers();
    }

}
