package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Secretaria;
import com.fiap.checkpoint.cp3.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaRepository repository;

    @GetMapping
    public List<Secretaria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Secretaria salvar(@RequestBody Secretaria secretaria) {
        return repository.save(secretaria);
    }

    @PutMapping("/{id}")
    public Secretaria atualizar(@PathVariable Long id, @RequestBody Secretaria secretaria) {
        secretaria.setId(id);
        return repository.save(secretaria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
