CREATE TABLE votacao
 (
     id                  NUMERIC(14, 0) NOT NULL IDENTITY (1,1),
     nome                VARCHAR(30)    NOT NULL UNIQUE,
     data_hora_inclusao  DATETIME2      NOT NULL,
     CONSTRAINT PK_PAUTA PRIMARY KEY (id)
 )