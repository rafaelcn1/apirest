package br.com.produto.apirest.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produto.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
