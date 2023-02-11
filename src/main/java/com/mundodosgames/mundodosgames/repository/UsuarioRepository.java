package com.mundodosgames.mundodosgames.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.mundodosgames.mundodosgames.model.Usuario;

@Repository
public interface UsuarioRepository {

	public Optional<Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}


