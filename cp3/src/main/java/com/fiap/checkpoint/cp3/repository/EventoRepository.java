package com.fiap.checkpoint.cp3.repository;

import com.fiap.checkpoint.cp3.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Page<Evento> findByArtistasNomeContainingIgnoreCase(String nome, Pageable pageable);
}
