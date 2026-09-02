package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.member.response;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    String name;
    String email;
    String documentNumber;
    LocalDate registrationDate;
    MemberStatus status;
    Integer maxSimultaneousLoan = 0;
}
