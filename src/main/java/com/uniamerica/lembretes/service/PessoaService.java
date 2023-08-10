package com.uniamerica.lembretes.service;

import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Transactional
    public Pessoa post(Pessoa pessoa){
        Assert.isTrue(pessoa.getNome().length() <= 50, "O nome da pessoa deve ter apenas 50 caracteres");
        Assert.isTrue(!repository.findByNome(pessoa.getNome()).isEmpty(), String.format("A pessoa %s já existe!", pessoa.getNome()));
        Assert.isTrue(pessoa.getNome().length() <= 50, "O nome da pessoa deve ter entre 3 e 50 caracteres");
        return repository.save(pessoa);
    }
}
