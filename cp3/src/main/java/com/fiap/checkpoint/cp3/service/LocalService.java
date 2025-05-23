package com.fiap.checkpoint.cp3.service;
import com.fiap.checkpoint.cp3.model.Local;
import com.fiap.checkpoint.cp3.repository.LocalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository repository;

    public List<Local> listar() {
        return repository.findAll();
    }

    public Local salvar(Local local) {
        return repository.save(local);
    }

    public Local atualizar(Long id, Local local) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Local não encontrado");
        }
        local.setId(id);
        return repository.save(local);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Local não encontrado");
        }
        repository.deleteById(id);
    }
}