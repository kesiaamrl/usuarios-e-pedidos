package br.com.tech4me.usuariosepedidos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

import br.com.tech4me.usuariosepedidos.model.Usuarios;
import br.com.tech4me.usuariosepedidos.service.UsuariosService;
import br.com.tech4me.usuariosepedidos.shared.UsuarioCompletoDto;
import br.com.tech4me.usuariosepedidos.shared.UsuarioDto;

@RestController
@RequestMapping("/usuarios")

public class UsuariosController {
@Autowired

private UsuariosService servico;
@GetMapping
public ResponseEntity<List<UsuarioDto>> obterUsuarios(){
    return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);

}

@GetMapping ("/{id}")
public ResponseEntity<UsuarioCompletoDto> obterPorId (@PathVariable String id) {
    Optional<UsuarioCompletoDto> retorno = servico.obterPorId(id);
    if (retorno.isPresent()){
        return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@PostMapping
public ResponseEntity<UsuarioCompletoDto> cadastrarUsuarios (@RequestBody UsuarioCompletoDto usuarios){
    return new ResponseEntity<>(servico.cadastrar(usuarios), HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<UsuarioCompletoDto> atualizarUsuarios (@PathVariable String id, @RequestBody UsuarioCompletoDto usuarios){
    Optional<UsuarioCompletoDto> retorno= servico.atualizarPorId(id, usuarios);
    if(retorno.isPresent()){
        return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else{
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> excluirPorId (@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
