package com.ifmt.estoque.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes_estoque")
public class MovimentacaoEstoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lote_id", nullable = false)
    private Lote lote;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDateTime dataMovimentacao;

    @Column(name = "tipo_movimentacao", nullable = false, length = 30)
    private String tipoMovimentacao;

    public MovimentacaoEstoque() {}

    public MovimentacaoEstoque(Lote lote, Integer quantidade, LocalDateTime dataMovimentacao, String tipoMovimentacao) {
        this.lote = lote;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Lote getLote() { return lote; }
    public void setLote(Lote lote) { this.lote = lote; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getDataMovimentacao() { return dataMovimentacao; }
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) { this.dataMovimentacao = dataMovimentacao; }

    public String getTipoMovimentacao() { return tipoMovimentacao; }
    public void setTipoMovimentacao(String tipoMovimentacao) { this.tipoMovimentacao = tipoMovimentacao; }
}