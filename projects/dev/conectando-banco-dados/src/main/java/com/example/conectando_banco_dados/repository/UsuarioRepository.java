package com.example.conectando_banco_dados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.conectando_banco_dados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUserName(String userName);
    
}
