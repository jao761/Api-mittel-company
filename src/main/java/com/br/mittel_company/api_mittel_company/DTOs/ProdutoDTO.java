package com.br.mittel_company.api_mittel_company.DTOs;

import com.br.mittel_company.api_mittel_company.Enums.Tamanho;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {

        @NotEmpty(message = "O campo nao pode estar vazio")
        private String nomeProduto;

        @NotEmpty(message = "O campo nao pode estar vazio")
        private String descricao;

        @Positive
        private BigDecimal preco;

        @Min(0)
        private int quantidade;

        @NotNull(message = "O campo nao pode estar nulo")
        private Tamanho tamanho;

        @NotNull(message = "A imagem não pode estar vazia")
        private byte[] imagemProduto;
    }
