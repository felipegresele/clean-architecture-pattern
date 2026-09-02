package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.request;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    String name;
    String email;
    String documentNumber;
    LocalDate registrationDate;
    MemberStatus status;
    Integer maxSimultaneousLoan = 0;
}
