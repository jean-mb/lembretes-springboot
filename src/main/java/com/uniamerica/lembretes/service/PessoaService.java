package com.uniamerica.lembretes.service;

import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;
    public PessoaDTO toPessoaDTO(Pessoa pessoa){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        return pessoaDTO;
    }
    public Pessoa toPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        return pessoa;
    }

    @Transactional
    public PessoaDTO post(PessoaDTO pessoa){
        Assert.isTrue(pessoa.getNome().length() <= 50, "O nome da pessoa deve ter apenas 50 caracteres");
        Assert.isTrue(repository.findByNome(pessoa.getNome()).isEmpty(), String.format("A pessoa %s já existe!", pessoa.getNome()));
        return toPessoaDTO(repository.save(toPessoa(pessoa)));
    }
    public List<PessoaDTO> findAll(){
        return repository.findAll().stream().map(this::toPessoaDTO).toList();
    }
    public PessoaDTO getById(Long id){
        Pessoa pessoaById = repository.findById(id).orElse(null);
        Assert.notNull(pessoaById, String.format("Pessoa com ID %s não existe!", id));
        return toPessoaDTO(pessoaById);
    }
    public PessoaDTO getByNome(String nome){
        Pessoa pessoaByNome = repository.findByNomeUnique(nome);
        Assert.notNull(pessoaByNome, String.format("Pessoa com nome %s não existe!", nome));
        return toPessoaDTO(pessoaByNome);
    }
    @Transactional
    public PessoaDTO update(Long id, PessoaDTO pessoa){
        Pessoa pessoaById = repository.findById(id).orElse(null);
        Assert.notNull(pessoaById, String.format("Pessoa com ID %s não existe!", id));
        return toPessoaDTO(repository.save(toPessoa(pessoa)));
    }
    @Transactional
    public void delete(Long id){
        Pessoa pessoaById = repository.findById(id).orElse(null);
        Assert.notNull(pessoaById, String.format("Pessoa com ID %s não existe!", id));
        repository.deleteById(id);
    }
}
