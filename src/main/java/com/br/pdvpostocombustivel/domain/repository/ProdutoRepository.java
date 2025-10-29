package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);
    Optional<Produto> findByReferencia(String referencia);
    Optional<Produto> findByMarca(String marca);
    boolean existsByNome(String nome);
    boolean existsByReferencia(String referencia);
    boolean existsByMarca(String marca);
}