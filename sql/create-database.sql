-- Cria o banco de dados
CREATE DATABASE "gestao_de_solicitacoes_internas";

-- Depois de executar o comando acima, conecte-se ao banco recém-criado antes de rodar os próximos comandos.

-- Criação das tabelas
CREATE TABLE "Usuario" (
    "id" SERIAL PRIMARY KEY,
    "nome" VARCHAR(120) NOT NULL,
    "email" VARCHAR(220) NOT NULL UNIQUE,
    "senha" VARCHAR(64) NOT NULL,
    "perfil" VARCHAR(20) NOT NULL
);

CREATE TABLE "Departamento" (
    "id" SERIAL PRIMARY KEY,
    "nome" VARCHAR(220) NOT NULL,
    "usuario_id" INTEGER,
    FOREIGN KEY ("usuario_id") REFERENCES "Usuario"("id") ON DELETE SET NULL
);

CREATE TABLE "Solicitacao" (
    "id" SERIAL PRIMARY KEY,
    "titulo" VARCHAR(220) NOT NULL,
    "descricao" VARCHAR(500),
    "data_criacao" TIMESTAMP NOT NULL,
    "status" VARCHAR(20) NOT NULL,
    "usuario_id" INTEGER,
    "departamento_id" INTEGER,
    FOREIGN KEY ("usuario_id") REFERENCES "Usuario"("id") ON DELETE SET NULL,
    FOREIGN KEY ("departamento_id") REFERENCES "Departamento"("id") ON DELETE SET NULL
);
	
-- Verificação do nome das sequências
SELECT * FROM pg_sequences

-- Verifique o nome das sequencias e altere se necessário, para evitar letras maiusculas
ALTER SEQUENCE "Usuario_id_seq" RENAME TO usuario_id_seq;
ALTER SEQUENCE "Departamento_id_seq" RENAME TO departamento_id_seq;
ALTER SEQUENCE "Solicitacao_id_seq" RENAME TO solicitacao_id_seq;

-- Criação do usuário
CREATE USER "gestao_de_solicitacoes_internas" WITH PASSWORD 'gestao_de_solicitacoes_internas';

-- Permissões de conexão ao banco
GRANT CONNECT ON DATABASE "gestao_de_solicitacoes_internas" TO "gestao_de_solicitacoes_internas";

-- Permissões no schema público
GRANT USAGE ON SCHEMA public TO "gestao_de_solicitacoes_internas";

-- Permissões em todas as tabelas existentes
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO "gestao_de_solicitacoes_internas";

-- Permissões em todas as sequências existentes (necessárias para colunas SERIAL/IDENTITY)
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA public TO "gestao_de_solicitacoes_internas";

-- Permissões para tabelas futuras no schema public
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO "gestao_de_solicitacoes_internas";

-- Permissões para sequências futuras no schema public
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT USAGE, SELECT, UPDATE ON SEQUENCES TO "gestao_de_solicitacoes_internas";

