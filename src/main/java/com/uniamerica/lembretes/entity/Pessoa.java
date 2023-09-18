package com.uniamerica.lembretes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
