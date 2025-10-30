package com.br.pdvpostocombustivel.api.preco.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PrecoRequest(
        @NotNull(message = "O valor não pode ser nulo.")
        BigDecimal valor,

        LocalDate dataAlteracao,

        BigDecimal valorAlteracao
) {}
