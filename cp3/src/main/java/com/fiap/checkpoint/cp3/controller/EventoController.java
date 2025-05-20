package com.fiap.checkpoint.cp3.controller;


import com.fiap.checkpoint.cp3.model.Evento;
import com.fiap.checkpoint.cp3.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping
    public Page<Evento> listar(@RequestParam(required = false) String artista, Pageable pageable) {
        if (artista != null) {
            return repository.findByArtistasNomeContainingIgnoreCase(artista, pageable);
        }
        return repository.findAll(pageable);
    }

    @PostMapping
    public Evento salvar(@RequestBody Evento evento) {
        return repository.save(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return repository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
