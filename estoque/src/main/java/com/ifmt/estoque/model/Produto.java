package com.ifmt.estoque.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(length = 50)
    private String categoria;

    @Column(name = "unidade_medida", length = 20)
    private String unidadeMedida;

    public Produto() {}

    public Produto(String nome, String descricao, String codigo, String categoria, String unidadeMedida) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.categoria = categoria;
        this.unidadeMedida = unidadeMedida;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(String unidadeMedida) { this.unidadeMedida = unidadeMedida; }
}