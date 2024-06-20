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

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
                                 @Autowired ProdutoRepository produtoRepository,
                                 @Autowired PedidoVendaRepository pedidoVendaRepository) {
        return args -> {
            // Populando tabela Cliente
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Fulano");
            cliente1.setEmail("fulano@email.com");
            cliente1.setEndereco("Rua XYZ");
            cliente1.setRazaoSocial("Fulaninho de Tal LTDA");
            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Ciclano");
            cliente2.setEmail("ciclano@hotmail.com");
            cliente2.setEndereco("Rua xxx, 1");
            cliente2.setRazaoSocial("Ciclano Eireli");
            clienteRepository.save(cliente2);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Beltrano");
            cliente3.setEmail("beltrano@gmail.com");
            cliente3.setEndereco("Rua ABC, 2");
            cliente3.setRazaoSocial("Beltrano Ltda");
            clienteRepository.save(cliente3);

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Maria");
            cliente4.setEmail("maria@exemplo.com");
            cliente4.setEndereco("Avenida 1, 3");
            cliente4.setRazaoSocial("Maria & Cia");
            clienteRepository.save(cliente4);

            Cliente cliente5 = new Cliente();
            cliente5.setNome("João");
            cliente5.setEmail("joao@exemplo.com");
            cliente5.setEndereco("Rua DEF, 4");
            cliente5.setRazaoSocial("João SA");
            clienteRepository.save(cliente5);

            // Populando tabela Produto
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

            Produto produto3 = new Produto();
            produto3.setDescricao("Tablet");
            produto3.setPreco(new BigDecimal(1000.00));
            produto3.setEstoque(8);
            produto3.setAtivo(true);
            produtoRepository.save(produto3);

            Produto produto4 = new Produto();
            produto4.setDescricao("Monitor");
            produto4.setPreco(new BigDecimal(500.00));
            produto4.setEstoque(15);
            produto4.setAtivo(true);
            produtoRepository.save(produto4);

            Produto produto5 = new Produto();
            produto5.setDescricao("Impressora");
            produto5.setPreco(new BigDecimal(700.00));
            produto5.setEstoque(7);
            produto5.setAtivo(true);
            produtoRepository.save(produto5);

            // Populando tabela PedidoVenda
            PedidoVenda ped1 = new PedidoVenda();
            ped1.setCliente(cliente2);
            ped1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            ped1.setEmissao(LocalDate.now());

            PedidoVendaItem item1 = new PedidoVendaItem();
            item1.setProduto(produto1);
            item1.setQuantidade(2);
            item1.setValorUnitario(produto1.getPreco());
            item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));
            ped1.addItem(item1);

            PedidoVendaItem item2 = new PedidoVendaItem();
            item2.setProduto(produto2);
            item2.setQuantidade(1);
            item2.setValorUnitario(produto2.getPreco());
            item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));
            ped1.addItem(item2);

            ped1.setTotal();
            pedidoVendaRepository.save(ped1);

            PedidoVenda ped2 = new PedidoVenda();
            ped2.setCliente(cliente3);
            ped2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            ped2.setEmissao(LocalDate.now());

            PedidoVendaItem item3 = new PedidoVendaItem();
            item3.setProduto(produto3);
            item3.setQuantidade(3);
            item3.setValorUnitario(produto3.getPreco());
            item3.setValorTotal(item3.getValorUnitario().multiply(BigDecimal.valueOf(item3.getQuantidade())));
            ped2.addItem(item3);

            PedidoVendaItem item4 = new PedidoVendaItem();
            item4.setProduto(produto4);
            item4.setQuantidade(2);
            item4.setValorUnitario(produto4.getPreco());
            item4.setValorTotal(item4.getValorUnitario().multiply(BigDecimal.valueOf(item4.getQuantidade())));
            ped2.addItem(item4);

            ped2.setTotal();
            pedidoVendaRepository.save(ped2);

            PedidoVenda ped3 = new PedidoVenda();
            ped3.setCliente(cliente4);
            ped3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            ped3.setEmissao(LocalDate.now());

            PedidoVendaItem item5 = new PedidoVendaItem();
            item5.setProduto(produto5);
            item5.setQuantidade(1);
            item5.setValorUnitario(produto5.getPreco());
            item5.setValorTotal(item5.getValorUnitario().multiply(BigDecimal.valueOf(item5.getQuantidade())));
            ped3.addItem(item5);

            PedidoVendaItem item6 = new PedidoVendaItem();
            item6.setProduto(produto1);
            item6.setQuantidade(4);
            item6.setValorUnitario(produto1.getPreco());
            item6.setValorTotal(item6.getValorUnitario().multiply(BigDecimal.valueOf(item6.getQuantidade())));
            ped3.addItem(item6);

            ped3.setTotal();
            pedidoVendaRepository.save(ped3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
