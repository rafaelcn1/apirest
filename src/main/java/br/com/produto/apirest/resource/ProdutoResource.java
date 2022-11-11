package br.com.produto.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.apirest.models.Produto;
import br.com.produto.apirest.reposiotory.ProdutoRepository;

/*
 * Essa classe é que vai receber as requisições http
 * 
 * */

@RestController // Anotação para aplicação REST
@RequestMapping(value = "/api") // Criação da uri padrão, ex: /api/produto
public class ProdutoResource {

	@Autowired // Se conectar ao banco de dados
	ProdutoRepository produtoRepository;

	// Metodo (via GET) para listar todos os produtos do banco de dados, teste pelo
	// postman
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	// Metodo (via GET) para listar apenas 1 produto no banco de dados, teste pelo
	// postman
	@GetMapping("/produto/{id}")
	public Produto findById(@PathVariable(value = "id") Long id) { //@PathVariable vai ser para passarmos o valor do id na url
		return produtoRepository.findById(id).orElse(null);
	}

	// Metodo post para salvar um produto novo
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) { // @RequestBody, a requisição vai pelo corpo da requisição, então o metodo vai receber o produto
		return produtoRepository.save(produto);
	}
	
	// Metodo para deletar um produto
	@DeleteMapping("/produto") // Metodo para deletar uma linha na tabela produto
	public void deletarProduto(@RequestBody Produto produto) { // @RequestBody, a requisição vai pelo corpo da requisição igual ao salvar, então o metodo vai receber o produto para poder deletar
		produtoRepository.delete(produto);
	}
	
	// Metodo post para salvar um produto novo
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) { // @RequestBody, a requisição vai pelo corpo da requisição, então o metodo vai receber o produto
		return produtoRepository.save(produto); // porque também é save? é porque como ele vai recer o produto completo pelo corpo da requisição @RequestBody, vai também o ID, então vai ser feito um "marge" 
	}
	
}
