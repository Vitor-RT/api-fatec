package br.com.api.fatec.apifatec;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@SpringBootApplication
public class ApiFatecApplication {
	
	@RequestMapping("/")
	String home() {
		return "hello world";
	}
	@RequestMapping("/hello")
	String home2() {
		return "hello world 2";
	}
	@RequestMapping("/numero")
	Integer numero() {
		return 2;
	}
	@RequestMapping("/numero/{num}")
	Integer numero2(@PathVariable Integer num) {
		return num;
	}
	@RequestMapping("/idade/{num}")
	String idade(@PathVariable int num) {
		String faixaetaria;
		if (num >= 0 && num < 12) {
			faixaetaria = "Criança";
		}
		else if (num >= 12 && num <= 18) {
			faixaetaria = "Adolescente";
		}
		else if (num >= 19 && num <= 60) {
			faixaetaria = "Adulto";
		}
		else if (num > 60) {
			faixaetaria = "Idoso";
		}
		else {
			faixaetaria = "Idade inválida";
		}
		return faixaetaria;
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
