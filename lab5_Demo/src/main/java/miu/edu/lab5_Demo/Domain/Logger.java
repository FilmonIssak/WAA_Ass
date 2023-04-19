package miu.edu.lab5_Demo.Domain;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDate date;
    private long time;
    private String principle;
    private String operation;
}
