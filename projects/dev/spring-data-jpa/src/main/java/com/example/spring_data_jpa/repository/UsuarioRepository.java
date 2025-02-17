package com.example.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_data_jpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUserName(String userName);
    
}
