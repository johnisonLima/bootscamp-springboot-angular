package com.example.conectando_banco_dados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.conectando_banco_dados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Query methods
    List<Usuario> findByNomeContaining(String nome);

    // Query methods
    Usuario findByUserName(String userName);

    // Query Ovveride
    @Query("SELECT u FROM Usuario u WHERE u.nome LIKE %:nome%")
    List<Usuario> buscarPorNome(@Param("nome") String nome);
    
}
