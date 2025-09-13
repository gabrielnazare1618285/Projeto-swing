package com.br.domain.entity;
import java.util.Date;

public class Pessoa {

    // atributos
    private String nomeCompleto;

    private String cpfCnpj;

    private Date dataNascimento;

    private Integer numeroCtps;



    // construtor
    public Pessoa(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

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