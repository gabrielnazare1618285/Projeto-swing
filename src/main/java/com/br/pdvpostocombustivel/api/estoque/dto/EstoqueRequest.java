package com.br.pdvpostocombustivel.api.estoque.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueRequest(
        @NotNull(message = "A quantidade não pode ser nula.")
        BigDecimal quantidade,

        String localTanque,

        String localEndereco,

        LocalDate dataFabricacao,

        LocalDate dataValidade
) {}
