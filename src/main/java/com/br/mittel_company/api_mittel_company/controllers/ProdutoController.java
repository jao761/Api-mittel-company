package com.br.mittel_company.api_mittel_company.controllers;

import com.br.mittel_company.api_mittel_company.DTOs.ProdutoDTO;
import com.br.mittel_company.api_mittel_company.Enums.Tamanho;
import com.br.mittel_company.api_mittel_company.entities.Produto;
import com.br.mittel_company.api_mittel_company.sevice.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PostMapping
    public ResponseEntity<String> criarProduto(
            @RequestParam("nomeProduto") String nomeProduto,
            @RequestParam("descricao") String descricao,
            @RequestParam("preco") BigDecimal preco,
            @RequestParam("quantidade") int quantidade,
            @RequestParam("tamanho") Tamanho tamanho,
            @RequestParam("imagemProduto") MultipartFile imagemProduto) throws IOException {

        try {
            // Verificar se a imagem foi recebida e não está vazia
            if (imagemProduto != null && !imagemProduto.isEmpty()) {
                byte[] imagemBytes = imagemProduto.getBytes();
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO.setNomeProduto(nomeProduto);
                produtoDTO.setDescricao(descricao);
                produtoDTO.setPreco(preco);
                produtoDTO.setQuantidade(quantidade);
                produtoDTO.setTamanho(tamanho);
                produtoDTO.setImagemProduto(imagemBytes); // Atribuindo a imagem no DTO

                String resposta = produtoService.criarProduto(produtoDTO);
                return ResponseEntity.ok(resposta);
            } else {
                return ResponseEntity.badRequest().body("Imagem não pode estar vazia");
            }

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar produto: " + e.getMessage());
        }
    }
}
