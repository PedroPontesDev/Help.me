package com.br.trentor.Help.me.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.trentor.Help.me.model.entities.Usuario;

public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

}
