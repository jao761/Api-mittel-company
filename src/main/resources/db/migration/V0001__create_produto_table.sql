CREATE TABLE produto (
    id              BIGINT          NOT NULL AUTO_INCREMENT,
    nomeProduto     VARCHAR(100)    NOT NULL,
    descricao       VARCHAR(255)    NOT NULL,
    preco           DECIMAL(10, 2)  NOT NULL,
    quantidade      INT             NOT NULL,
    tamanho         ENUM('P', 'M', 'G', 'GG') NOT NULL,
    destaque        BOOLEAN         NOT NULL DEFAULT FALSE,
    imagemProduto   BLOB            NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
