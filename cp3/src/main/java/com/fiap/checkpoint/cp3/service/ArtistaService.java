package com.fiap.checkpoint.cp3.service;

import com.fiap.checkpoint.cp3.model.Artista;
import com.fiap.checkpoint.cp3.repository.ArtistaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository repository;

    public List<Artista> listar() {
        return repository.findAll();
    }

    public Artista salvar(Artista artista) {
        return repository.save(artista);
    }

    public Artista atualizar(Long id, Artista artista) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Artista não encontrado");
        }
        artista.setId(id);
        return repository.save(artista);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Artista não encontrado");
        }
        repository.deleteById(id);
    }
}
