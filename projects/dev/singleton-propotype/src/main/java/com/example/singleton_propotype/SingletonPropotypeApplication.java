package com.example.singleton_propotype;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.singleton_propotype.app.SistemaMensagem;

@SpringBootApplication
public class SingletonPropotypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonPropotypeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(SistemaMensagem sistemaMensagem) throws Exception {
		return args -> {
			sistemaMensagem.enviarConfirmacaoCadastro();
			sistemaMensagem.enviarMensagemBoasVindas();
			sistemaMensagem.enviarConfirmacaoCadastro();
		};
	}

}
