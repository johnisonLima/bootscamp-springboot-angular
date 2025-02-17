package com.example.conectando_banco_dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.conectando_banco_dados.model.Usuario;
import com.example.conectando_banco_dados.repository.UsuarioRepository;

@Component
public class StratApp implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository; 

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();

        usuario.setUserName("admin");
        usuario.setSenha("admin");
        usuario.setNome("Administrador");

        usuarioRepository.save(usuario);

        for (Usuario u : usuarioRepository.findAll()) {
            System.out.println(u);
        }

    }
    
}
