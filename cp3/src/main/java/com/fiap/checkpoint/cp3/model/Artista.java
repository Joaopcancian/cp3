package com.fiap.checkpoint.cp3.model;

import jakarta.persistence.*;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String estiloArtistico;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

}