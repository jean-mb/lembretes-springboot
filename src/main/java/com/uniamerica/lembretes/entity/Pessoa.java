package com.uniamerica.lembretes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    @Column(unique = true, nullable = false)
    private String nome;
}
