CREATE TABLE "addresses"(
    "id" UUID PRIMARY KEY NOT NULL,
    "id_city" UUID NOT NULL,
    "street" VARCHAR(150) NOT NULL,
    "number" BIGINT NOT NULL,
    "complement" TEXT NULL,
    "reference_point" TEXT NULL
);