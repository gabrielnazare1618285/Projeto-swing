package com.br.pdvpostocombustivel.domain.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal quantidade;
    private String LocalTanque;
    private String LocalEndereco;
    private String Fabricacao;
    private String datavalidade;

    public Estoque(BigDecimal quantidade, String LocalEndereco, String LocalTanque, String Fabricacao, String datavalidade) {
        this.quantidade = quantidade;
        this.LocalEndereco = LocalEndereco;
        this.LocalTanque = LocalTanque;
        this.Fabricacao = Fabricacao;
        this.datavalidade = datavalidade;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public String getLocalTanque() {
        return LocalTanque;
    }
    public void setLocalTanque(String LocalTanque) {
        this.LocalTanque = LocalTanque;
    }
    public String getLocalEndereco() {
        return LocalEndereco;
    }
    public void setLocalEndereco(String LocalEndereco) {
        this.LocalEndereco = LocalEndereco;
    }
    public String getFabricacao() {
        return Fabricacao;
    }
    public void setFabricacao(String Fabricacao) {
        this.Fabricacao = Fabricacao;
    }
    public String getDatavalidade() {
        return datavalidade;
    }
    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    protected Estoque() {}
}