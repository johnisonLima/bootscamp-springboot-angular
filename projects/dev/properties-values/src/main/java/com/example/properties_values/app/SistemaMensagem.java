package com.example.properties_values.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner {

    @Value("${nome:Desconhecido}")
    private String nome;

    @Value("${email:sem@email.com}")
    private String email;

    @Value("${telefones}")
    private List<Long> telefones;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Nome: " + nome + " - Email: " + email + " - Telefones: " + telefones);
        
        System.out.println("Seu cadastro foi realizado com sucesso!");
    }    
}
