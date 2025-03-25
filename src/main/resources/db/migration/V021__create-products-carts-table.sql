CREATE TABLE "products_carts"(
    "id_product" UUID NOT NULL,
    "id_cart" UUID NOT NULL,
    "quantity" BIGINT NOT NULL,
    PRIMARY KEY("id_product","id_cart")
);