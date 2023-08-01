package br.com.tech4me.usuariosepedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.usuariosepedidos.model.Usuarios;
import br.com.tech4me.usuariosepedidos.repository.UsuarioRepositorio;
import br.com.tech4me.usuariosepedidos.shared.UsuarioCompletoDto;
import br.com.tech4me.usuariosepedidos.shared.UsuarioDto;

@Service
public class UsuarioServiceImpl implements UsuariosService {
@Autowired

private UsuarioRepositorio repository;
    @Override
    public List<UsuarioDto> obterTodas() {
        return repository.findAll()
        .stream().map(p -> new UsuarioDto(p.getId(), p.getNome(), p.getEndereco())) 
        .toList();
    }

    @Override
    public Optional<UsuarioCompletoDto> obterPorId(String id) {
       Optional<Usuarios> usuarios=repository.findById(id);
       if(usuarios.isPresent()){
        return Optional.of(new UsuarioCompletoDto(usuarios.get().getId(), usuarios.get().getNome(), usuarios.get().getEmail(), 
        usuarios.get().getEndereco()));

       }else{
        return Optional.empty();
       }
    }

    @Override
    public UsuarioCompletoDto cadastrar(UsuarioCompletoDto dto) {
        Usuarios usuarios = new Usuarios(dto);
        repository.save(usuarios);
        return new UsuarioCompletoDto(usuarios.getId(), usuarios.getNome(), usuarios.getEmail(), usuarios.getEndereco());
    }

    @Override
    public Optional<UsuarioCompletoDto> atualizarPorId(String id, UsuarioCompletoDto dto) {
        Optional<Usuarios> usuarios=repository.findById(id);
        if(usuarios.isPresent()){
            Usuarios usuariosAtualizado = new Usuarios(dto);
            usuariosAtualizado.setId(id);
            repository.save(usuariosAtualizado);
            return Optional.of(new UsuarioCompletoDto(usuariosAtualizado.getId(), usuariosAtualizado.getNome(), usuariosAtualizado.getEmail(),
            usuariosAtualizado.getEndereco())) ;
        } else{
            return Optional.empty();
        }
        
    }

    @Override
    public void excluirPorId(String id) {
        repository.deleteById(id);
    }
    
}
