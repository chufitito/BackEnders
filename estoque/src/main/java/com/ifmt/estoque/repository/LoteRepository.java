package com.ifmt.estoque.repository;

import com.ifmt.estoque.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    
    List<Lote> findAllByOrderByDataValidadeAsc();
    // Busca lotes com estoque maior que zero cuja validade esteja entre a data de início e fim
    List<Lote> findByDataValidadeBetweenAndQuantidadeGreaterThan(LocalDate inicio, LocalDate fim, Integer quantidadeMinima);

    // Opcional: Busca lotes já vencidos (validade anterior a hoje)
    List<Lote> findByDataValidadeBeforeAndQuantidadeGreaterThan(LocalDate dataLimite, Integer quantidadeMinima);

    List<Lote> findByProdutoIdAndQuantidadeGreaterThanOrderByDataValidadeAsc(Long produtoId, Integer quantidadeMinima);
}