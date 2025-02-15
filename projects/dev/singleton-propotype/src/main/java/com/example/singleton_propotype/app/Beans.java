package com.example.singleton_propotype.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean
    @Scope("prototype")
    public Remetente remetente() {
        System.out.println("CRIOU UM REMETENTE");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@email.com");
        remetente.setNome("No Reply");

        return remetente;
    }
}
