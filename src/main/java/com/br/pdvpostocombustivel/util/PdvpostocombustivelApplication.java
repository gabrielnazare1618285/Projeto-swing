package com.br.pdvpostocombustivel.util;

import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdvpostocombustivelApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PdvpostocombustivelApplication.class, args);


        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNomeCompleto("Rud");
        pessoa1.setCpfCnpj("21434532");
        pessoa1.setNumeroCtps(123);
        System.out.println(pessoa1.getNomeCompleto());
        System.out.println(pessoa1.getCpfCnpj());
        System.out.println(pessoa1.getNumeroCtps());


    }
}