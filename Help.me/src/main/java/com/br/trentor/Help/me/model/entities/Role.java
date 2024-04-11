package com.br.trentor.Help.me.model.entities;

import java.io.Serializable;
import java.util.Objects;

import com.br.trentor.Help.me.model.entities.security.enumerated.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_papeis_usuario")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoDeUsuario;

	public Role(Long id, TipoUsuario tipoDeUsuario) {
		this.id = id;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public Role() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoDeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id) && tipoDeUsuario == other.tipoDeUsuario;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", tipoDeUsuario=" + tipoDeUsuario + "]";
	}
	
	
	
	
	
}
