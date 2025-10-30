package com.br.pdvpostocombustivel.api.produto.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoRequest(
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @NotBlank(message = "A referência não pode estar em branco.")
        String referencia,

        String marca,

        String fornecedor
) {}
