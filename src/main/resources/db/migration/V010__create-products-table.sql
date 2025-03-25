CREATE TABLE "products"(
    "id" UUID PRIMARY KEY NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "description" TEXT NULL,
    "price" DECIMAL(8, 2) NOT NULL,
    "stock_quantity" BIGINT NOT NULL
);
