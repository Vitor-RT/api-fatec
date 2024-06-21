package br.com.api.fatec.apifatec.controllers;

import br.com.api.fatec.apifatec.entities.Transportadora;
import br.com.api.fatec.apifatec.domain.transportadora.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @PostMapping
    public ResponseEntity<Transportadora> createTransportadora(@RequestBody Transportadora transportadora) {
        Transportadora createdTransportadora = transportadoraService.createTransportadora(transportadora);
        return ResponseEntity.ok(createdTransportadora);
    }

    @GetMapping
    public ResponseEntity<List<Transportadora>> getAllTransportadoras() {
        List<Transportadora> transportadoras = transportadoraService.getAllTransportadoras();
        return ResponseEntity.ok(transportadoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transportadora> getTransportadoraById(@PathVariable Long id) {
        Transportadora transportadora = transportadoraService.getTransportadoraById(id).orElseThrow(() -> new RuntimeException("Transportadora not found"));
        return ResponseEntity.ok(transportadora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transportadora> updateTransportadora(@PathVariable Long id, @RequestBody Transportadora transportadoraDetails) {
        Transportadora updatedTransportadora = transportadoraService.updateTransportadora(id, transportadoraDetails);
        return ResponseEntity.ok(updatedTransportadora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportadora(@PathVariable Long id) {
        transportadoraService.deleteTransportadora(id);
        return ResponseEntity.ok().build();
    }
}
