package br.com.tech4me.usuariosepedidos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.usuariosepedidos.model.Usuarios;

public interface UsuarioRepositorio extends MongoRepository<Usuarios, String> {
    
}
