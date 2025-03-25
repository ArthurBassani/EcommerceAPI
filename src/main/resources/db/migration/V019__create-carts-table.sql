CREATE TABLE "carts"(
    "id" UUID PRIMARY KEY NOT NULL,
    "id_user" UUID NOT NULL,
    "total_value" DECIMAL(8, 2) NOT NULL
);