package com.br.mittel_company.api_mittel_company.sevice;

import com.br.mittel_company.api_mittel_company.DTOs.ProdutoDTO;
import com.br.mittel_company.api_mittel_company.Repositorys.ProdutoRepository;
import com.br.mittel_company.api_mittel_company.entities.Produto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public String criarProduto(ProdutoDTO produtoDTO) throws IOException {
        // Criar um novo objeto Produto e preencher com os dados do DTO
        Produto produto = new Produto();
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setTamanho(produtoDTO.getTamanho());
        produto.setImagemProduto(produtoDTO.getImagemProduto()); // A imagem já está no formato correto

        // Salvar no banco de dados
        produtoRepository.save(produto);

        return "Produto salvo com sucesso!";
    }
}
