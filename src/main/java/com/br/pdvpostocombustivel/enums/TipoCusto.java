package com.br.pdvpostocombustivel.enums;

public enum TipoCusto {
    COMBUSTIVEL("Compra de Combustível"),
    MANUTENCAO("Manutenção de Equipamentos"),
    SALARIO("Salário de Funcionários"),
    CONTAS("Contas"),
    IMPOSTOS("Impostos e Taxas"),
    LIMPEZA("Serviços de Limpeza");

    private final String descricao;

    TipoCusto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}