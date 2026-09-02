package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.FineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Fine")
public class FineEntity {

    @Id
    String id;
    String loanId;
    String memberId;
    BigDecimal amount;
    LocalDate generatedDate;
    LocalDate paidDate = null;
    FineStatus status = FineStatus.PENDING;
}