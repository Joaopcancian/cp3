package com.fiap.checkpoint.cp3.controller;

import com.fiap.checkpoint.cp3.model.Evento;
import com.fiap.checkpoint.cp3.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public Page<Evento> listar(@RequestParam(required = false) String artista, Pageable pageable) {
        return service.listar(artista, pageable);
    }

    @PostMapping
    public Evento salvar(@RequestBody Evento evento) {
        return service.salvar(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        return service.atualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

