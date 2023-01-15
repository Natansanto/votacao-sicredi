CREATE TABLE voto
 (
     id                  NUMERIC(14, 0) NOT NULL IDENTITY (1,1),
     nome                VARCHAR(30)    NOT NULL UNIQUE,
     cpf       			 VARCHAR(11)    NOT NULL,
     voto                VARCHAR(2)     NOT NULL,
     data_hora_inclusao  DATETIME2      NOT NULL,
     CONSTRAINT PK_VOTO PRIMARY KEY (id),
     CONSTRAINT CHK_VOTO_VOTO CHECK (status = 'SIM' OR status = 'NAO')
 )