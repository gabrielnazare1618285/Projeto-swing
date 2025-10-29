package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Integer> {
    Optional<Custo> findByImposto(Double Imposto);
    Optional<Custo> findByFrete(Double frete);
    Optional<Custo> findBySeguro(Double seguro);
    Optional<Custo> findByCustoVariavel(Double custoVariavel);
    Optional<Custo> findByCustoFixo(Double custoFixo);
    Optional<Custo> findByMargemLucro(Double margemLucro);
    boolean existsByImposto(Double Imposto);
    boolean existsByFrete(Double frete);
    boolean existsBySeguro(Double seguro);
    boolean existsByCustoVariavel(Double custoVariavel);
    boolean existsByCustoFixo(Double custoFixo);
    boolean existsByMargemLucro(Double margemLucro);
}