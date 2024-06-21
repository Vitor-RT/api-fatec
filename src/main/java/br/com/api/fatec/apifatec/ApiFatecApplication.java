package br.com.api.fatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.domain.transportadora.TransportadoraRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.entities.Produto;
import br.com.api.fatec.apifatec.entities.Transportadora;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
								 @Autowired ProdutoRepository produtoRepository,
								 @Autowired PedidoVendaRepository pedidoVendaRepository,
								 @Autowired TransportadoraRepository transportadoraRepository) {
		return args -> {
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

			Produto produto1 = new Produto();
			produto1.setDescricao("Notebook");
			produto1.setPreco(new BigDecimal(2500.00));
			produto1.setEstoque(10);
			produto1.setAtivo(true);
			produtoRepository.save(produto1);

			Produto produto2 = new Produto();
			produto2.setDescricao("Celular");
			produto2.setPreco(new BigDecimal(1500.00));
			produto2.setEstoque(5);
			produto2.setAtivo(true);
			produtoRepository.save(produto2);

			PedidoVenda ped = new PedidoVenda();
			ped.setCliente(cliente2);
			ped.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data = LocalDate.now();
			ped.setEmissao(data);

			// Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item1 = new PedidoVendaItem();
			item1.setProduto(produto1);
			item1.setQuantidade(10);
			item1.setValorUnitario(new BigDecimal(1500));
			item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));
			ped.addItem(item1);

			// Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item2 = new PedidoVendaItem();
			item2.setProduto(produto2);
			item2.setQuantidade(5);
			item2.setValorUnitario(new BigDecimal(1000));
			item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));
			ped.addItem(item2);

			// Calculando total dos itens do Pedido Venda
			ped.setTotal();
			pedidoVendaRepository.save(ped);

			// Criando e salvando transportadoras
			Transportadora transportadora1 = new Transportadora();
			transportadora1.setNome("Transportadora ABC");
			transportadora1.setTelefone("123456789");
			transportadoraRepository.save(transportadora1);

			Transportadora transportadora2 = new Transportadora();
			transportadora2.setNome("Transportadora XYZ");
			transportadora2.setTelefone("987654321");
			transportadoraRepository.save(transportadora2);

			Transportadora transportadora3 = new Transportadora();
			transportadora3.setNome("Transportadora Rápida");
			transportadora3.setTelefone("1122334455");
			transportadoraRepository.save(transportadora3);

			Transportadora transportadora4 = new Transportadora();
			transportadora4.setNome("Transportadora Expressa");
			transportadora4.setTelefone("2233445566");
			transportadoraRepository.save(transportadora4);

			Transportadora transportadora5 = new Transportadora();
			transportadora5.setNome("Transportadora Segura");
			transportadora5.setTelefone("3344556677");
			transportadoraRepository.save(transportadora5);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}
