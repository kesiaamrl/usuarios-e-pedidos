package br.com.tech4me.usuariosepedidos.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.usuariosepedidos.shared.UsuarioCompletoDto;
import br.com.tech4me.usuariosepedidos.shared.UsuarioDto;

public interface UsuariosService {
        List<UsuarioDto> obterTodas();
    Optional<UsuarioCompletoDto> obterPorId(String id);
    UsuarioCompletoDto cadastrar(UsuarioCompletoDto dto);
    Optional <UsuarioCompletoDto> atualizarPorId(String id, UsuarioCompletoDto dto);
    void excluirPorId(String id);
    }

