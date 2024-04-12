package br.com.api.fatec.apifatec.controllers.exercicios;

import java.util.List;

import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.domain.produto.ProdutoMapper;
import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;
import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/produtos/")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
		List<ProdutoDTO> produto = ProdutoMapper.toDTOList(produtoService.listarProdutos());
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> encontrarProdutoPorId(@PathVariable Long id) {
		ProdutoDTO produto = ProdutoMapper.toDTO(produtoService.encontrarProdutoPorId(id));
		return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
		Produto produto = ProdutoMapper.toEntity(produtoDTO);
		ProdutoDTO produtoSalvo = ProdutoMapper.toDTO(produtoService.salvarProduto(produto));
		return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}