package com.br.trentor.Help.me.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.trentor.Help.me.model.entities.Usuario;

public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

}
