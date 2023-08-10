package com.uniamerica.lembretes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lembretes")
public class Lembrete {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter @Setter
    private String recado;

    @ManyToOne
    @JoinColumn
    private Pessoa pessoa_id;

}
