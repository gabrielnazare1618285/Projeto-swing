package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {
    Optional<Custo> findByImposto(BigDecimal imposto);
    Optional<Custo> findByFrete(BigDecimal frete);
    Optional<Custo> findBySeguro(BigDecimal seguro);
    Optional<Custo> findByCustoVariavel(BigDecimal custoVariavel);
    Optional<Custo> findByCustoFixo(BigDecimal custoFixo);
    Optional<Custo> findByMargemLucro(BigDecimal margemLucro);
    boolean existsByImposto(BigDecimal imposto);
    boolean existsByFrete(BigDecimal frete);
    boolean existsBySeguro(BigDecimal seguro);
    boolean existsByCustoVariavel(BigDecimal custoVariavel);
    boolean existsByCustoFixo(BigDecimal custoFixo);
    boolean existsByMargemLucro(BigDecimal margemLucro);
}
