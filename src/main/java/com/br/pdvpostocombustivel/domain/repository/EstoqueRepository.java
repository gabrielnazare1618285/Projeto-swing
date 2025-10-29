package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Optional<Estoque> findByQuantidade(Double quantidade);
    Optional<Estoque> findByLocalTanque(String LocalTanque);
    Optional<Estoque> findByLocalEndereco(String LocalEndereco);
    Optional<Estoque> findByFabricacao(String Fabricacao);
    Optional<Estoque> findByDatavalidade(String datavalidade);
    boolean existsByQuantidade(Double quantidade);
    boolean existsByLocalTanque(String LocalTanque);
    boolean existsByLocalEndereco(String LocalEndereco);
    boolean existsByFabricacao(String Fabricacao);
    boolean existsByDatavalidade(String datavalidade);
}