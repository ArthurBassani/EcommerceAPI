CREATE TABLE "cities"(
    "id" UUID PRIMARY KEY NOT NULL,
    "id_state" UUID NOT NULL,
    "cep" BIGINT UNIQUE NOT NULL,
    "name" VARCHAR(100) NOT NULL
);