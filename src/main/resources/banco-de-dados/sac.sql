CREATE TABLE TB_TICKET (
    id               VARCHAR2(36)       DEFAULT SYS_GUID() NOT NULL,
    id_cliente       VARCHAR2(36)       NOT NULL,
    titulo           VARCHAR2(200) NOT NULL,
    descricao        CLOB,
    status           VARCHAR2(50)  NOT NULL,
    prioridade       VARCHAR2(50)  NOT NULL,
    dataCriacao      TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    dataAtualizacao  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_ticket          PRIMARY KEY (id),
    CONSTRAINT fk_cliente  FOREIGN KEY (id_cliente)
        REFERENCES TB_CLIENTE (id_cliente)
);

CREATE TABLE TB_MENSAGEM (
    id          VARCHAR2(36)       DEFAULT SYS_GUID() NOT NULL,
    id_ticket   VARCHAR2(36)       NOT NULL,
    conteudo    CLOB          NOT NULL,
    autor       VARCHAR2(200) NOT NULL,
    dataEnvio   TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_mensagem        PRIMARY KEY (id),
    CONSTRAINT fk_mensagem_ticket FOREIGN KEY (id_ticket)
        REFERENCES TICKET (id)
        ON DELETE CASCADE
);