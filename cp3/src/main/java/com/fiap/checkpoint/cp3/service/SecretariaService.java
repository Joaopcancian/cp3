package com.fiap.checkpoint.cp3.service;


import com.fiap.checkpoint.cp3.model.Secretaria;
import com.fiap.checkpoint.cp3.repository.SecretariaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository repository;

    public List<Secretaria> listar() {
        return repository.findAll();
    }

    public Secretaria salvar(Secretaria secretaria) {
        return repository.save(secretaria);
    }

    public Secretaria atualizar(Long id, Secretaria secretaria) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Secretaria não encontrada");
        }
        secretaria.setId(id);
        return repository.save(secretaria);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Secretaria não encontrada");
        }
        repository.deleteById(id);
    }
}