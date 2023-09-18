package com.uniamerica.lembretes;

import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.controller.PessoaController;
import com.uniamerica.lembretes.entity.Lembrete;
import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.repository.PessoaRepository;
import com.uniamerica.lembretes.service.PessoaService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

@SpringBootTest
public class PessoaTests {

    @MockBean
    PessoaRepository repository;
    @Autowired
    PessoaController controller;
    @Autowired
    PessoaService service;
    Pessoa pessoa = new Pessoa(1L, "Jean");
    List<Pessoa> pessoas = Arrays.asList(pessoa);
    @BeforeEach
    void injectData(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(pessoa));
        Mockito.when(repository.findAll()).thenReturn(pessoas);
    }
    @Test
    void testControllerGetId(){
        var pessoaController = controller.getById(1L);
        Long id = Objects.requireNonNull(pessoaController.getBody()).getId();
        Assertions.assertEquals(1L, id, 0);
    }
    @Test
    void testControllerGetAll() {
        List<PessoaDTO> pessoasController = controller.getAll().getBody();
//        Assertions.assertEquals(pessoas.stream().map(pessoa1 -> service.toPessoaDTO(pessoa1)).toList(), pessoasController);
        Assertions.assertTrue(pessoasController.containsAll(pessoas.stream().map(pessoa1 -> service.toPessoaDTO(pessoa1)).toList()));

    }
}
