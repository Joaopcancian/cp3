package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Artista;
import com.fiap.checkpoint.cp3.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @GetMapping
    public List<Artista> listar() {
        return service.listar();
    }

    @PostMapping
    public Artista salvar(@RequestBody Artista artista) {
        return service.salvar(artista);
    }

    @PutMapping("/{id}")
    public Artista atualizar(@PathVariable Long id, @RequestBody Artista artista) {
        return service.atualizar(id, artista);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}