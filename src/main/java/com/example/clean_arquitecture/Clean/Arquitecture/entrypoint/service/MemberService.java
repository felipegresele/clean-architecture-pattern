package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.useCase.*;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.response.MemberResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    //Use Case
    private final SaveMember saveMember;
    private final GetListMembers getListMembers;
    private final GetMemberById getMemberById;
    private final DeleteMemberById deleteMemberById;
    private final UpdateMember updateMember;

    public ResponseEntity<MemberResponse> saveMember(MemberRequest request) {
        Member member = this.saveMember.execute(request);
        return new ResponseEntity<>(MemberMapper.toEntityToResponse(member), HttpStatus.CREATED);
    }

    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<Member> members = this.getListMembers.execute();
        return new ResponseEntity<>(MemberMapper.toListMemberResponse(members), HttpStatus.OK);
    }

    public ResponseEntity<MemberResponse> getMemberById(String id) {
        Member member = this.getMemberById.execute(id);
        return new ResponseEntity<>(MemberMapper.toEntityToResponse(member), HttpStatus.OK);
    }

    public ResponseEntity<MemberResponse> updateMemberById(String id, MemberRequest request) {
        Member member = this.updateMember.execute(id, request);
        return new ResponseEntity<>(MemberMapper.toEntityToResponse(member), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMemberById(String id) {
        this.deleteMemberById.execute(id);
        return new ResponseEntity<>("Member with Id " + id + " deleted", HttpStatus.OK);
    }
}
