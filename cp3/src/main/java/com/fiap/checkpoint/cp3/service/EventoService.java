package com.fiap.checkpoint.cp3.service;

import com.fiap.checkpoint.cp3.model.Evento;
import com.fiap.checkpoint.cp3.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public Page<Evento> listar(String artista, Pageable pageable) {
        if (artista != null) {
            return repository.findByArtistasNomeContainingIgnoreCase(artista, pageable);
        }
        return repository.findAll(pageable);
    }

    public Evento salvar(Evento evento) {
        return repository.save(evento);
    }

    public Evento atualizar(Long id, Evento evento) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Evento não encontrado");
        }
        evento.setId(id);
        return repository.save(evento);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Evento não encontrado");
        }
        repository.deleteById(id);
    }
}
