package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository<Preco, Integer> {
    Optional<Preco> findbyValor(BigDecimal valor);
    Optional<Preco> findbyDataAlteracao(String dataAlteracao);
    Optional<Preco> findbyValorAlteracao(String valorAlteracao);
    boolean existsByDataAlteracao(String dataAlteracao);
    boolean existsByValorAlteracao(String valorAlteracao);
    boolean existsByValor(BigDecimal valor);
}
