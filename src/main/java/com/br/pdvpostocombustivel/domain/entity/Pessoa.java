package com.br.pdvpostocombustivel.domain.entity;
import jakarta.persistence.*;
import jakarta.websocket.OnMessage;

import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)

    private String nomeCompleto;

    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @Column(length = 12)
    private Date dataNascimento;

    @Column(length = 8, nullable = false)
    private Integer numeroCtps;



    // construtor
    public Pessoa(String nomeCompleto,  String cpfCnpj, Date dataNascimento, Integer numeroCtps, Long id) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }
    public Pessoa() {}

    // getters
    public String getNomeCompleto(){
        return nomeCompleto;
    }
    // setters
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfCnpj(){
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public Date getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Integer getNumeroCtps(){
        return numeroCtps;
    }
    public void setNumeroCtps(Integer numeroCtps){
        this.numeroCtps = numeroCtps;
    }
}