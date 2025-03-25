CREATE TABLE "states"(
    "id" UUID PRIMARY KEY NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "abbreviation" VARCHAR(3) UNIQUE NOT NULL
);