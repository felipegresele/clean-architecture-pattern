package com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    String name;
    String email;
    String documentNumber;
    LocalDate registrationDate;
    MemberStatus status;
    Integer maxSimultaneousLoan = 0;
}
