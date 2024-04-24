package com.br.trentor.Help.me.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.trentor.Help.me.model.entities.Role;
import com.br.trentor.Help.me.model.entities.security.enumerated.TipoUsuario;

import org.springframework.data.repository.query.Param;


@Repository
public interface RoleRepositories extends JpaRepository<Role, Long> {

	@Query("SELECT r FROM Role r WHERE r.tipoDeUsuario = :tipoUsuario")
	Role findByTipoDeUsuario(@Param("tipoUsuario") TipoUsuario tipoUsuario);

}
