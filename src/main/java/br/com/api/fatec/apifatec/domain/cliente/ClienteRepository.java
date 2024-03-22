package br.com.api.fatec.apifatec.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.fatec.apifatec.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
