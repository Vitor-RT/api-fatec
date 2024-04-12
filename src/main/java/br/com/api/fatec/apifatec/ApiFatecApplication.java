package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository) {
		return args ->{
			Cliente cliente = new Cliente();
			cliente.setNome("Fulano");
			cliente.setEmail("fulano@email.com");
			cliente.setEndereco("Rua XYZ");
			cliente.setRazaoSocial("Fulaninho de Tal LTDA");
			
			clienteRepository.save(cliente);
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Ciclano");
			cliente2.setEmail("ciclano@hotmail.com");
			cliente2.setEndereco("Rua xxx, 1");
			cliente2.setRazaoSocial("Ciclano Eireli");

			clienteRepository.save(cliente2);
		};
	}
	public CommandLineRunner run(@Autowired ProdutoRepository produtoRepository) {
		return args ->{
			Produto produto = new Produto();
			produto.setDescricao("Notebook");
			produto.setPreco(2500.00);
			produto.setEstoque(10);
			produto.setAtivo(true);
			produtoRepository.save(produto);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
