package com.br.pdvpostocombustivel.api.estoque.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueResponse(
        Long id,
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        LocalDate dataFabricacao,
        LocalDate dataValidade
) {}
