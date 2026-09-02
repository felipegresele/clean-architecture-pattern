package com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> getMemberById(String id);

    List<Member> getAllMembers();

    void delete(String id);
}
