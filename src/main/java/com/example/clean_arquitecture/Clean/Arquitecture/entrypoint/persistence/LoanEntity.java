package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Loan")
public class LoanEntity {

    @Id
    String memberId;
    LocalDate loanDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Integer renewalCount;
    LoanStatus status;
}