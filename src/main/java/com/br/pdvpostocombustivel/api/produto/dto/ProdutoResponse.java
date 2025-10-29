package com.br.pdvpostocombustivel.api.produto.dto;

import com.br.pdvpostocombustivel.enums.TipoProduto;
import org.springframework.format.annotation.DateTimeFormat;

public record ProdutoResponse (
        String nome,
        String referencia,
        String marca
)
{}