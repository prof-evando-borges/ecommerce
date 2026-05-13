DROP TABLE TB_AVALIACAO;
DROP TABLE TB_COMENTARIO;

CREATE TABLE TB_AVALIACAO (
                              ID VARCHAR2(36) PRIMARY KEY,
                              ID_PRODUTO NUMBER NOT NULL,
                              ID_CLIENTE NUMBER NOT NULL,
                              ID_LOJISTA NUMBER NOT NULL,
                              NOTA NUMBER(1)NOT NULL,
                              CONSTRAINT CK_NOTA CHECK (NOTA BETWEEN 0 AND 5),

                              CONSTRAINT FK_AV_PRODUTO
                                  FOREIGN KEY (ID_PRODUTO) REFERENCES TB_PRODUTO(ID),

                              CONSTRAINT FK_AV_CLIENTE
                                  FOREIGN KEY (ID_CLIENTE) REFERENCES TB_CLIENTE(ID),

                              CONSTRAINT FK_AV_LOJISTA
                                  FOREIGN KEY (ID_LOJISTA) REFERENCES TB_LOJISTA(ID)
);

CREATE TABLE TB_COMENTARIO (
                               ID VARCHAR2(36) PRIMARY KEY,
                               ID_PRODUTO NUMBER NOT NULL,
                               ID_CLIENTE NUMBER NOT NULL,
                               ID_LOJISTA NUMBER NOT NULL,
                               ID_AVALIACAO VARCHAR2(36) NOT NULL,
                               COMENTARIO VARCHAR2(255) NOT NULL,

                               CONSTRAINT FK_COMENTARIO_AVALIACAO
                                   FOREIGN KEY (ID_AVALIACAO) REFERENCES TB_AVALIACAO(ID),
                               CONSTRAINT FK_COMENTARIO_PRODUTO
                                   FOREIGN KEY (ID_PRODUTO) REFERENCES TB_PRODUTO(ID),

                               CONSTRAINT FK_COMENTARIO_CLIENTE
                                   FOREIGN KEY (ID_CLIENTE) REFERENCES TB_CLIENTE(ID),

                               CONSTRAINT FK_COMENTARIO_LOJISTA
                                   FOREIGN KEY (ID_LOJISTA) REFERENCES TB_LOJISTA(ID)
);