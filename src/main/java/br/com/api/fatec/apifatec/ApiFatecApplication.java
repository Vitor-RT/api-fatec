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
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.entities.Produto;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;

@SpringBootApplication
public class ApiFatecApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
                                 @Autowired ProdutoRepository produtoRepository,
                                 @Autowired PedidoVendaRepository pedidoVendaRepository
    ) {
        return args -> {
            // Adicionando Clientes
            Cliente cliente1 = new Cliente();
            cliente1.setNome("João Silva");
            cliente1.setEmail("joao.silva@example.com");
            cliente1.setEndereco("Rua A, 123");
            cliente1.setRazaoSocial("João Silva ME");
            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Maria Oliveira");
            cliente2.setEmail("maria.oliveira@example.com");
            cliente2.setEndereco("Avenida B, 456");
            cliente2.setRazaoSocial("Maria Oliveira LTDA");
            clienteRepository.save(cliente2);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Carlos Pereira");
            cliente3.setEmail("carlos.pereira@example.com");
            cliente3.setEndereco("Travessa C, 789");
            cliente3.setRazaoSocial("Carlos Pereira EPP");
            clienteRepository.save(cliente3);

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Ana Costa");
            cliente4.setEmail("ana.costa@example.com");
            cliente4.setEndereco("Alameda D, 101");
            cliente4.setRazaoSocial("Ana Costa MEI");
            clienteRepository.save(cliente4);

            Cliente cliente5 = new Cliente();
            cliente5.setNome("Luiz Souza");
            cliente5.setEmail("luiz.souza@example.com");
            cliente5.setEndereco("Praça E, 202");
            cliente5.setRazaoSocial("Luiz Souza e Cia");
            clienteRepository.save(cliente5);

            // Adicionando Produtos
            Produto produto1 = new Produto();
            produto1.setDescricao("Notebook Dell Inspiron");
            produto1.setPreco(new BigDecimal("3500.00"));
            produto1.setEstoque(25);
            produto1.setAtivo(true);
            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setDescricao("Smartphone Samsung Galaxy");
            produto2.setPreco(new BigDecimal("2000.00"));
            produto2.setEstoque(50);
            produto2.setAtivo(true);
            produtoRepository.save(produto2);

            Produto produto3 = new Produto();
            produto3.setDescricao("Smart TV LG 50 Polegadas");
            produto3.setPreco(new BigDecimal("2800.00"));
            produto3.setEstoque(15);
            produto3.setAtivo(true);
            produtoRepository.save(produto3);

            Produto produto4 = new Produto();
            produto4.setDescricao("Câmera Canon EOS Rebel");
            produto4.setPreco(new BigDecimal("4500.00"));
            produto4.setEstoque(10);
            produto4.setAtivo(true);
            produtoRepository.save(produto4);

            Produto produto5 = new Produto();
            produto5.setDescricao("Fone de Ouvido Bluetooth Sony");
            produto5.setPreco(new BigDecimal("350.00"));
            produto5.setEstoque(100);
            produto5.setAtivo(true);
            produtoRepository.save(produto5);

            // Adicionando Pedidos de Venda
            PedidoVenda pedido1 = new PedidoVenda();
            pedido1.setCliente(cliente1);
            pedido1.setEmissao(LocalDate.parse("2024-06-15"));
            pedido1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            PedidoVendaItem item1 = new PedidoVendaItem();
            item1.setProduto(produto1);
            item1.setQuantidade(2);
            pedido1.addItem(item1);
            PedidoVendaItem item2 = new PedidoVendaItem();
            item2.setProduto(produto5);
            item2.setQuantidade(3);
            pedido1.addItem(item2);
            pedidoVendaRepository.save(pedido1);

            PedidoVenda pedido2 = new PedidoVenda();
            pedido2.setCliente(cliente2);
            pedido2.setEmissao(LocalDate.parse("2024-06-16"));
            pedido2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            PedidoVendaItem item3 = new PedidoVendaItem();
            item3.setProduto(produto2);
            item3.setQuantidade(1);
            pedido2.addItem(item3);
            PedidoVendaItem item4 = new PedidoVendaItem();
            item4.setProduto(produto3);
            item4.setQuantidade(2);
            pedido2.addItem(item4);
            pedidoVendaRepository.save(pedido2);

            PedidoVenda pedido3 = new PedidoVenda();
            pedido3.setCliente(cliente3);
            pedido3.setEmissao(LocalDate.parse("2024-06-17"));
            pedido3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            PedidoVendaItem item5 = new PedidoVendaItem();
            item5.setProduto(produto3);
            item5.setQuantidade(1);
            pedido3.addItem(item5);
            PedidoVendaItem item6 = new PedidoVendaItem();
            item6.setProduto(produto4);
            item6.setQuantidade(2);
            pedido3.addItem(item6);
            pedidoVendaRepository.save(pedido3);

            PedidoVenda pedido4 = new PedidoVenda();
            pedido4.setCliente(cliente4);
            pedido4.setEmissao(LocalDate.parse("2024-06-18"));
            pedido4.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            PedidoVendaItem item7 = new PedidoVendaItem();
            item7.setProduto(produto4);
            item7.setQuantidade(1);
            pedido4.addItem(item7);
            PedidoVendaItem item8 = new PedidoVendaItem();
            item8.setProduto(produto1);
            item8.setQuantidade(1);
            pedido4.addItem(item8);
            pedidoVendaRepository.save(pedido4);

            PedidoVenda pedido5 = new PedidoVenda();
            pedido5.setCliente(cliente5);
            pedido5.setEmissao(LocalDate.parse("2024-06-19"));
            pedido5.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            PedidoVendaItem item9 = new PedidoVendaItem();
            item9.setProduto(produto2);
            item9.setQuantidade(1);
            pedido5.addItem(item9);
            PedidoVendaItem item10 = new PedidoVendaItem();
            item10.setProduto(produto5);
            item10.setQuantidade(2);
            pedido5.addItem(item10);
            pedidoVendaRepository.save(pedido5);
        };
    }
}
