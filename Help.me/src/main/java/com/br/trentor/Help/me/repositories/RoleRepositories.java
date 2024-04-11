package com.br.trentor.Help.me.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.trentor.Help.me.model.entities.Role;

@Repository
public interface RoleRepositories extends JpaRepository<Role, Long> {

}
