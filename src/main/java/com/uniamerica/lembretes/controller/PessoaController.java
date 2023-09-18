package com.uniamerica.lembretes.controller;

import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.repository.PessoaRepository;
import com.uniamerica.lembretes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaDTO> post(@RequestBody PessoaDTO pessoa){
        return ResponseEntity.ok(service.post(pessoa));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PessoaDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<PessoaDTO> getByNome(@RequestParam String nome){
        return ResponseEntity.ok(service.getByNome(nome));
    }

    @PutMapping("/editar")
    public ResponseEntity<PessoaDTO> update(@RequestParam Long id, @RequestBody PessoaDTO pessoa){
        return ResponseEntity.ok(service.update(id, pessoa));
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<?> delete(@RequestParam Long id){
        service.delete(id);
        return ResponseEntity.ok(String.format("Pessoa com ID %s deletado com sucesso!", id));
    }
}
