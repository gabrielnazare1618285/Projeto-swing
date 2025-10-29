package com.br.pdvpostocombustivel.enums;

public enum TipoProduto {
    GASOLINA_COMUM("Gasolina Comum"),
    GASOLINA_ADITIVADA("Gasolina Aditivada"),
    ETANOL("Etanol"),
    DIESEL_S500("Diesel S-500"),
    DIESEL_S10("Diesel S-10"),
    GNV("Gás Natural Veicular"),
    OLEO_LUBRIFICANTE("Óleo Lubrificante"),
    ADITIVO_RADIADOR("Aditivo para Radiador"),
    LIMPA_VIDRO("Limpa Vidro"),
    REFRIGERANTE("Refrigerante"),
    AGUA("Água Mineral"),
    SNACK("Snack ou Salgadinho");

    private final String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}