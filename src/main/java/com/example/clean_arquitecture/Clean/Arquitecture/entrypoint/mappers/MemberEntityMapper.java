package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.LoanEntity;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.MemberEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberEntityMapper {

    public static MemberEntity domainToEntity(Member member) {
        MemberEntity entity = new MemberEntity();
        entity.setName(member.getName());
        entity.setEmail(member.getEmail());
        entity.setDocumentNumber(member.getDocumentNumber());
        entity.setRegistrationDate(member.getRegistrationDate());
        entity.setStatus(member.getStatus());
        entity.setMaxSimultaneousLoan(member.getMaxSimultaneousLoan());

        return entity;
    }

    public static Member entityToDomain(MemberEntity entity) {
        Member member = new Member();
        member.setName(entity.getName());
        member.setEmail(entity.getEmail());
        member.setDocumentNumber(entity.getDocumentNumber());
        member.setRegistrationDate(entity.getRegistrationDate());
        member.setStatus(entity.getStatus());
        member.setMaxSimultaneousLoan(entity.getMaxSimultaneousLoan());

        return member;
    }

    public static List<Member> listMemberDomain(List<MemberEntity> list) {
        List<Member> listDomain = new ArrayList<>();
        for (MemberEntity memberEntity : list) {
            listDomain.add(entityToDomain(memberEntity));
        }
        return listDomain;
    }
}
