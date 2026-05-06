CREATE TABLE TB_AVALIACAO (
                              ID VARCHAR2(36) PRIMARY KEY,
                              ID_PRODUTO NUMBER,
                              ID_CLIENTE NUMBER,
                              ID_LOGISTA NUMBER,
                              ID_COMENTARIO NUMBER,
                              NOTA NUMBER(1)
);



CREATE TABLE TB_COMENTARIO (
                               ID VARCHAR2(36) PRIMARY KEY,
                               ID_PRODUTO NUMBER,
                               ID_CLIENTE NUMBER,
                               ID_LOGISTA NUMBER,
                               ID_COMENTARIO NUMBER,
                               COMENTARIO VARCHAR(255)
);

 