package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.response.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberMapper {

    public static MemberResponse toEntityToResponse(Member member) {
        MemberResponse response = new MemberResponse();
        response.setName(member.getName());
        response.setEmail(member.getEmail());
        response.setDocumentNumber(member.getDocumentNumber());
        response.setRegistrationDate(member.getRegistrationDate());
        response.setStatus(member.getStatus());
        response.setMaxSimultaneousLoan(member.getMaxSimultaneousLoan());

        return response;
    }

    public Member toRequestToEntity(MemberRequest request) {
        Member entity = new Member();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setDocumentNumber(request.getDocumentNumber());
        entity.setRegistrationDate(request.getRegistrationDate());
        entity.setStatus(request.getStatus());
        entity.setMaxSimultaneousLoan(request.getMaxSimultaneousLoan());

        return entity;
    }

    public static List<MemberResponse> toListMemberResponse(List<Member> memberList) {
        List<MemberResponse> responseList = new ArrayList<>();
        for (Member member : memberList) {
            MemberResponse memberResponse = toEntityToResponse(member);
            responseList.add(memberResponse);
        }
        return responseList;
    }

    public static void updateMember(Member entity, MemberRequest request) {
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setDocumentNumber(request.getDocumentNumber());
        entity.setRegistrationDate(request.getRegistrationDate());
        entity.setStatus(request.getStatus());
        entity.setMaxSimultaneousLoan(request.getMaxSimultaneousLoan());
    }

}
