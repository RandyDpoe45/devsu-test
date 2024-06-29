package com.github.RandyDpoe45.account_server.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String number;

    private Long accountOwnerId;

    @ManyToOne(targetEntity = AccountType.class, fetch = FetchType.EAGER)
    private AccountType accountType;

    @ManyToOne(targetEntity = AccountStatus.class, fetch = FetchType.EAGER)
    private AccountStatus accountStatus;

    private BigDecimal initialBalance;
}
