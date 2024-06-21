package br.com.api.fatec.apifatec.domain.transportadora;

import br.com.api.fatec.apifatec.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
}
