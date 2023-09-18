package com.uniamerica.lembretes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lembretes")
@NoArgsConstructor
@AllArgsConstructor
public class Lembrete {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String recado;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

}
