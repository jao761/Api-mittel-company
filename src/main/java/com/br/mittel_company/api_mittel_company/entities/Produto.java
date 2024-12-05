package com.br.mittel_company.api_mittel_company.entities;

import com.br.mittel_company.api_mittel_company.Enums.Tamanho;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O nome do produto é obrigatório.") // Não permite nulo nem vazio
        @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres.")
        @Column(name = "nomeProduto", nullable = false, length = 100)
        private String nomeProduto;

        @NotBlank(message = "A descrição do produto é obrigatória.")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
        @Column(name = "descricao", nullable = false, length = 255)
        private String descricao;

        @NotNull(message = "O preço do produto é obrigatório.")
        @DecimalMin(value = "0.01", inclusive = false, message = "O preço deve ser maior que zero.")
        @Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos inteiros e 2 decimais.")
        @Column(name = "preco", nullable = false, precision = 10, scale = 2)
        private BigDecimal preco;

        @NotNull(message = "A quantidade é obrigatória.")
        @Min(value = 0, message = "A quantidade não pode ser negativa.")
        @Column(name = "quantidade", nullable = false)
        private Integer quantidade;

        @NotNull(message = "O tamanho é obrigatório.")
        @Enumerated(EnumType.STRING)
        @Column(name = "tamanho", nullable = false)
        private Tamanho tamanho;

        @NotNull(message = "A imagem do produto é obrigatória.")
        @Lob
        @Column(name = "imagem-produto", nullable = false)
        private byte[] imagemProduto;
}
