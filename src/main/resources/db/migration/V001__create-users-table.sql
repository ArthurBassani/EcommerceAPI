CREATE TABLE "users"(
    "id" UUID PRIMARY KEY NOT NULL,
    "id_role" UUID NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "document" VARCHAR(16) UNIQUE NOT NULL,
    "email" VARCHAR(100) UNIQUE NOT NULL,
    "password" VARCHAR(100) NOT NULL,
    "phone" VARCHAR(20) NOT NULL,
    "birthdate" DATE NULL
);