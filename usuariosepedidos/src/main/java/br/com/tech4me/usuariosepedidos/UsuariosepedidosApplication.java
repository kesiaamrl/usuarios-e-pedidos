package br.com.tech4me.usuariosepedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsuariosepedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosepedidosApplication.class, args);
	}

}
