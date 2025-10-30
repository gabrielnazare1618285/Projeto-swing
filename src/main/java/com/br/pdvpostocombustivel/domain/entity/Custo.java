package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "custos")
public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imposto", precision = 10, scale = 2)
    private BigDecimal imposto;

    @Column(name = "frete", precision = 10, scale = 2)
    private BigDecimal frete;

    @Column(name = "seguro", precision = 10, scale = 2)
    private BigDecimal seguro;

    @Column(name = "custo_variavel", precision = 10, scale = 2)
    private BigDecimal custoVariavel;

    @Column(name = "custo_fixo", precision = 10, scale = 2)
    private BigDecimal custoFixo;

    @Column(name = "margem_lucro", precision = 10, scale = 2)
    private BigDecimal margemLucro;

    @Column(name = "data_processamento")
    private LocalDate dataProcessamento;

    public Long getId() {
        return id;
    }

    public BigDecimal getImposto() {
        return imposto;
    }

    public void setImposto(BigDecimal imposto) {
        this.imposto = imposto;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public BigDecimal getCustoVariavel() {
        return custoVariavel;
    }

    public void setCustoVariavel(BigDecimal custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public BigDecimal getCustoFixo() {
        return custoFixo;
    }

    public void setCustoFixo(BigDecimal custoFixo) {
        this.custoFixo = custoFixo;
    }

    public BigDecimal getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(BigDecimal margemLucro) {
        this.margemLucro = margemLucro;
    }

    public LocalDate getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(LocalDate dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    /**
     * @deprecated Construtor para uso exclusivo do JPA.
     */
    @Deprecated
    protected Custo() {}

    public Custo(BigDecimal imposto, BigDecimal frete, BigDecimal seguro, BigDecimal custoVariavel, BigDecimal custoFixo, BigDecimal margemLucro, LocalDate dataProcessamento) {
        this.imposto = imposto;
        this.frete = frete;
        this.seguro = seguro;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
    }
}
