package com.uniamerica.lembretes.service;

import com.uniamerica.lembretes.DTO.LembreteDTO;
import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.entity.Lembrete;
import com.uniamerica.lembretes.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository repository;

    @Autowired
    private PessoaService pessoaService;
    public Lembrete toLembrete(LembreteDTO lembreteDTO){
        Lembrete lembrete = new Lembrete();
        lembrete.setId(lembreteDTO.getId());
        lembrete.setRecado(lembreteDTO.getRecado());
        lembrete.setPessoa(lembreteDTO.getPessoa());
        return lembrete;
    }
    public LembreteDTO toLembreteDTO(Lembrete lembrete){
        LembreteDTO lembreteDTO= new LembreteDTO();
        lembreteDTO.setId(lembrete.getId());
        lembreteDTO.setRecado(lembrete.getRecado());
        lembreteDTO.setPessoa(lembrete.getPessoa());
        return lembreteDTO;
    }
    @Transactional
    public LembreteDTO post(LembreteDTO lembreteDTO) {
        Assert.notNull(lembreteDTO.getRecado(), "Informe um recado!");
        Assert.notNull(lembreteDTO.getPessoa(), "Informe a pessoa desse recado!");
        PessoaDTO pessoa = pessoaService.getById(lembreteDTO.getPessoa().getId());
        Assert.notNull(pessoa, "Pessoa não existe!");
        return toLembreteDTO(repository.save(toLembrete(lembreteDTO)));
    }

    public List<LembreteDTO> findAll() {
        return repository.findAll().stream().map(this::toLembreteDTO).toList();
    }
    public LembreteDTO getById(Long id){
        Lembrete lembreteById = repository.findById(id).orElse(null);
        Assert.notNull(lembreteById, String.format("Lembrete com ID %s não existe!", id));
        return toLembreteDTO(lembreteById);
    }
    @Transactional
    public LembreteDTO update(Long id, LembreteDTO lembreteDTO){
        Lembrete lembreteById = repository.findById(id).orElse(null);
        Assert.notNull(lembreteById, String.format("Lembrete com ID %s não existe!", id));
        Assert.notNull(lembreteDTO.getPessoa(), "Informe a pessoa desse recado!");
        PessoaDTO pessoa = pessoaService.getById(lembreteDTO.getPessoa().getId());
        Assert.notNull(pessoa, "Pessoa não existe!");
        return toLembreteDTO(repository.save(toLembrete(lembreteDTO)));
    }
    @Transactional
    public void delete(Long id){
        Lembrete lembreteById = repository.findById(id).orElse(null);
        Assert.notNull(lembreteById, String.format("Lembrete com ID %s não existe!", id));
        repository.deleteById(id);
    }
}
