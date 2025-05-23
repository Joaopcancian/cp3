package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Local;
import com.fiap.checkpoint.cp3.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {

    @Autowired
    private LocalService service;

    @GetMapping
    public List<Local> listar() {
        return service.listar();
    }

    @PostMapping
    public Local salvar(@RequestBody Local local) {
        return service.salvar(local);
    }

    @PutMapping("/{id}")
    public Local atualizar(@PathVariable Long id, @RequestBody Local local) {
        return service.atualizar(id, local);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}