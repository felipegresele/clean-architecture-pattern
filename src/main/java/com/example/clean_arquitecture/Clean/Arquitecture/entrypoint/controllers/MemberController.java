package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request.MemberRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.response.MemberResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(description = "Get all members")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return this.memberService.getAllMembers();
    }

    @PostMapping("/save")
    @Operation(description = "Save member")
    @ApiResponse(responseCode = "201", description = "Insert successful")
    public ResponseEntity<MemberResponse> save(@RequestBody MemberRequest request) {
        return this.memberService.saveMember(request);
    }

    @GetMapping("/get-member/{id}")
    @Operation(description = "Find member by id")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<MemberResponse> findMemberById(
            @PathVariable String id) {
        return this.memberService.getMemberById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update member by id")
    @ApiResponse(responseCode = "201", description = "Updated successful")
    public ResponseEntity<MemberResponse> updateMember(
            @PathVariable String id,
            @RequestBody MemberRequest memberRequest) {
        return this.memberService.updateMemberById(id, memberRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete member by id")
    @ApiResponse(responseCode = "204", description = "Deleted successful, no content")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.memberService.deleteMemberById(id);
    }
}
