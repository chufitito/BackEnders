package com.ifmt.estoque.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "lotes")
public class Lote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_lote", nullable = false, length = 50)
    private String numeroLote;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    // Relacionamento N:1 - Muitos lotes pertencem a um Produto
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    // Relacionamento N:1 - Muitos lotes podem vir de um Fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    // Construtores
    public Lote() {}

    public Lote(String numeroLote, Integer quantidade, LocalDate dataValidade, Produto produto, Fornecedor fornecedor) {
        this.numeroLote = numeroLote;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.produto = produto;
        this.fornecedor = fornecedor;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroLote() { return numeroLote; }
    public void setNumeroLote(String numeroLote) { this.numeroLote = numeroLote; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }
}