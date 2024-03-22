package br.com.api.fatec.apifatec.controllers.exercicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.fatec.apifatec.domain.cliente.ClienteService;
import br.com.api.fatec.apifatec.entities.Cliente;

@RestController
@RequestMapping("/api/clientes/v1")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> clientes = clienteService.listarClientes();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
}
