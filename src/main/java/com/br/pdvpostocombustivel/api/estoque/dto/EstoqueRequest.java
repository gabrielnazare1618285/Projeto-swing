package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

public record EstoqueRequest (
        BigDecimal quantidade,
        String LocalTanque,
        String LocalEndereco,
        String Fabricacao,
        String dataValidade,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        TipoEstoque tipoEstoque
)
{}