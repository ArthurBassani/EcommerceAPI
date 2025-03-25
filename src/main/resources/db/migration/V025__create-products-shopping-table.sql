CREATE TABLE "products_shopping"(
    "id_product" UUID NOT NULL,
    "id_shop" UUID NOT NULL,
    "buy_price" DECIMAL(8, 2) NOT NULL,
    "quantity" BIGINT NOT NULL,
    PRIMARY KEY("id_product","id_shop")
);
