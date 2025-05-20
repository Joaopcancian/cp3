package com.fiap.checkpoint.cp3.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Local local;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Artista> artistas;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Secretaria secretaria;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

}