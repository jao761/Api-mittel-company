package com.br.mittel_company.api_mittel_company.Repositorys;

import com.br.mittel_company.api_mittel_company.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
