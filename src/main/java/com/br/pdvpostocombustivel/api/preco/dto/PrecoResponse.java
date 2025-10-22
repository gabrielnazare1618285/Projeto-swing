package com.br.pdvpostocombustivel.api.preco.dto;

import java.time.LocalDate;
import java.math.BigDecimal;
public record PrecoResponse (
        BigDecimal valor,
        String dataAlteracao,
        String valorAlteracao
){}
