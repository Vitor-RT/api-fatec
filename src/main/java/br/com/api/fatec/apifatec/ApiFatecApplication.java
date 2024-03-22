package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.entities.Cliente;

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
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
