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
@Table(name = "tbl_bank_account_transaction",schema = "test")
public class BankAccountTransactionEntity implements Serializable {
//tbl_bank_account_transaction

    @Id
    @Column(name = "id")
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
