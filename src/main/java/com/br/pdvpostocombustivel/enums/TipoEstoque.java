package com.br.pdvpostocombustivel.enums;

public enum TipoEstoque {
    COMBUSTIVEL("Combustível"),
    LUBRIFICANTE("Lubrificante"),
    ADITIVO("Aditivo"),
    LIMPEZA_AUTOMOTIVA("Produto de Limpeza Automotiva"),
    CONVENIENCIA("Produto de Conveniência"),
    PECA_VEICULAR("Peça Veicular");

    private final String descricao;

    TipoEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}