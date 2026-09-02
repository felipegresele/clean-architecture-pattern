package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.response.MemberResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return this.memberService.getAllMembers();
    }

    @PostMapping("/save")
    public ResponseEntity<MemberResponse> save(@RequestBody MemberRequest request) {
        return this.memberService.saveMember(request);
    }

    @GetMapping("/get-member/{id}")
    public ResponseEntity<MemberResponse> findMemberById(
            @PathVariable String id) {
        return this.memberService.getMemberById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberResponse> updateMember(
            @PathVariable String id,
            @RequestBody MemberRequest memberRequest) {
        return this.memberService.updateMemberById(id, memberRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.memberService.deleteMemberById(id);
    }
}
