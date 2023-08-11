package com.uniamerica.lembretes.controller;

import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.repository.PessoaRepository;
import com.uniamerica.lembretes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> post(@RequestBody PessoaDTO pessoa){
        try {
            return ResponseEntity.ok(service.post(pessoa));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.ok(service.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try{
            return ResponseEntity.ok(service.getById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/nome")
    public ResponseEntity<?> getByNome(@RequestParam String nome){
        try{
            return ResponseEntity.ok(service.getByNome(nome));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody PessoaDTO pessoa){
        try{
            return ResponseEntity.ok(service.update(id, pessoa));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<?> delete(@RequestParam Long id){
        try{
            service.delete(id);
            return ResponseEntity.ok(String.format("Pessoa com ID %s deletado com sucesso!", id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
