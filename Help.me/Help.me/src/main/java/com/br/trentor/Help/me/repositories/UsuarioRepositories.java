package com.br.trentor.Help.me.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.trentor.Help.me.model.entities.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

}
