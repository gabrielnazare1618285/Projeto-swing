package com.br.pdvpostocombustivel.api.custo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CustoResponse(
        Long id,
        BigDecimal imposto,
        BigDecimal frete,
        BigDecimal seguro,
        BigDecimal custoVariavel,
        BigDecimal custoFixo,
        BigDecimal margemLucro,
        LocalDate dataProcessamento
) {}
