package com.fiap.checkpoint.cp3.controller;


import com.fiap.checkpoint.cp3.model.Secretaria;
import com.fiap.checkpoint.cp3.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService service;

    @GetMapping
    public List<Secretaria> listar() {
        return service.listar();
    }

    @PostMapping
    public Secretaria salvar(@RequestBody Secretaria secretaria) {
        return service.salvar(secretaria);
    }

    @PutMapping("/{id}")
    public Secretaria atualizar(@PathVariable Long id, @RequestBody Secretaria secretaria) {
        return service.atualizar(id, secretaria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}