package com.ifmt.estoque.service;

import java.time.LocalDate;
import com.ifmt.estoque.model.Lote;
import com.ifmt.estoque.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {

    @Autowired
    private LoteRepository loteRepository;

    public List<Lote> listarTodos() {
        return loteRepository.findAllByOrderByDataValidadeAsc();
    }

    public Lote buscarPorId(Long id) {
        return loteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lote não encontrado com o ID: " + id));
    }

    public Lote salvar(Lote lote) {
        return loteRepository.save(lote);
    }

    public void deletar(Long id) {
        loteRepository.deleteById(id);
    }

    public List<Lote> listarLotesProximosVencimento(int diasLimite) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.plusDays(diasLimite);
        
        return loteRepository.findByDataValidadeBetweenAndQuantidadeGreaterThan(hoje, dataLimite, 0);
    }

    public List<Lote> listarLotesVencidos() {
        LocalDate hoje = LocalDate.now();
        return loteRepository.findByDataValidadeBeforeAndQuantidadeGreaterThan(hoje, 0);
    }
}