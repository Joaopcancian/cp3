package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Local;
import com.fiap.checkpoint.cp3.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @GetMapping
    public List<Local> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Local salvar(@RequestBody Local local) {
        return repository.save(local);
    }

    @PutMapping("/{id}")
    public Local atualizar(@PathVariable Long id, @RequestBody Local local) {
        local.setId(id);
        return repository.save(local);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
