package br.com.produto.apirest.reposiotory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produto.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	// Metodo para procurar um produto pelo ID
	Optional<Produto> findById(Long id);

}
