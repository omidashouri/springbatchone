package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans;

import io.micrometer.core.annotation.Counted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBL_BANK_ACCOUNT_TRANSACTION",schema = "test")
public class BankAccountTransactionEntity implements Serializable {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACC_NUMBER")
    private int accNumber;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "TX_DATE")
    private Date txDate;

    @Column(name = "TX_ID")
    private int txId;

}
