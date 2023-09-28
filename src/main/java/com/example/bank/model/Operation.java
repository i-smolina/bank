package com.example.bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private float amount;
    @NotNull
    private LocalDate date;
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "src_account_id")
    Client src_client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dst_account_id")
    Client dst_client;
}
