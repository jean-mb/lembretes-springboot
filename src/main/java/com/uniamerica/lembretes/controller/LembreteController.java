package com.uniamerica.lembretes.controller;

import com.uniamerica.lembretes.DTO.LembreteDTO;
import com.uniamerica.lembretes.DTO.PessoaDTO;
import com.uniamerica.lembretes.entity.Pessoa;
import com.uniamerica.lembretes.service.LembreteService;
import com.uniamerica.lembretes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    @Autowired
    private LembreteService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> post(@RequestBody LembreteDTO lembrete){
        try {
            return ResponseEntity.ok(service.post(lembrete));
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
    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody LembreteDTO lembrete){
        try{
            return ResponseEntity.ok(service.update(id, lembrete));
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
