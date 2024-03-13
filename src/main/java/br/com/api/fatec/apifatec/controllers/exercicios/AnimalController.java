package br.com.api.fatec.apifatec.controllers.exercicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AnimalController {
	@RequestMapping(value = "/animal/{types}", method = RequestMethod.GET)
	public List<String> getAnimalSounds(@PathVariable String types[]) {
		int tam = types.length;
		List<String> sons = new ArrayList<>();
		for(int i = 0; i < tam; i++){
			sons.add(getSoundByAnimalType(types[i]));
		}
		return sons;
	}
	private String getSoundByAnimalType(String nome){
		switch (nome.toLowerCase()) {
			case "cachorro":
				return "AuAu";
			case "gato":
				return "Miau";
			case "vaca":
				return "Muuu";
			case "ovelha":
				return "Bééé";
			case "porco":
				return "Ronc";
			case "passaro":
				return "Piu";
			default:
				return "Animal desconhecido";
		}
	}
}
