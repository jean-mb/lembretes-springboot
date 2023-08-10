package com.uniamerica.lembretes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter @Setter
    private String nome;
}
