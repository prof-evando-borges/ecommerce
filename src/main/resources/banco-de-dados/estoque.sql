CREATE TABLE estoque (
    id RAW(16) DEFAULT SYS_GUID() PRIMARY KEY,
    responsavel_id NUMBER,
    peso_total NUMBER(10,2),
    valor_total NUMBER(10,2),

    CONSTRAINT fk_estoque_responsavel
        FOREIGN KEY (responsavel_id)
        REFERENCES lojista(id)
);

CREATE TABLE setor (
    id RAW(16) DEFAULT SYS_GUID() PRIMARY KEY,
    nome VARCHAR2(255),
    numero_corredor NUMBER,
    prateleiras NUMBER,
    estoque_id RAW(16),

    CONSTRAINT fk_setor_estoque
        FOREIGN KEY (estoque_id)
        REFERENCES estoque(id)
);