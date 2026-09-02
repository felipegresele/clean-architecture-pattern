package com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMemberById {

    private final MemberRepository memberRepository;

    public void execute(String id) {
        this.memberRepository.delete(id);
    }

}
