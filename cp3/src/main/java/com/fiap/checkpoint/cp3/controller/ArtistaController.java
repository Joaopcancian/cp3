package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Artista;
import com.fiap.checkpoint.cp3.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository repository;

    @GetMapping
    public List<Artista> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Artista salvar(@RequestBody Artista artista) {
        return repository.save(artista);
    }

    @PutMapping("/{id}")
    public Artista atualizar(@PathVariable Long id, @RequestBody Artista artista) {
        artista.setId(id);
        return repository.save(artista);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}