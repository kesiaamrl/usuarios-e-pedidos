package br.com.tech4me.usuariosepedidos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.usuariosepedidos.shared.UsuarioCompletoDto;

@Document("usuarios")
public class Usuarios {
    @Id
    private String id;
    private String nome;
    private String email;
    private String endereco;

    public Usuarios (){}

    public Usuarios(UsuarioCompletoDto dto){
        this.email=dto.email();
        this.endereco=dto.endereco();
        this.id=dto.id();
        this.nome=dto.nome();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
 public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    

}
