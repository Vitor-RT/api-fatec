package br.com.api.fatec.apifatec.domain.transportadora;

import br.com.api.fatec.apifatec.entities.Transportadora;
import br.com.api.fatec.apifatec.domain.transportadora.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    public Transportadora createTransportadora(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    public List<Transportadora> getAllTransportadoras() {
        return transportadoraRepository.findAll();
    }

    public Optional<Transportadora> getTransportadoraById(Long id) {
        return transportadoraRepository.findById(id);
    }

    public Transportadora updateTransportadora(Long id, Transportadora transportadoraDetails) {
        Transportadora transportadora = transportadoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportadora not found"));

        transportadora.setNome(transportadoraDetails.getNome());
        transportadora.setTelefone(transportadoraDetails.getTelefone());

        return transportadoraRepository.save(transportadora);
    }

    public void deleteTransportadora(Long id) {
        Transportadora transportadora = transportadoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportadora not found"));
        transportadoraRepository.delete(transportadora);
    }
}
