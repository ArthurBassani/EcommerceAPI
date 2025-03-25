CREATE TABLE "products_sales"(
    "id_product" UUID NOT NULL,
    "id_sale" UUID NOT NULL,
    "sale_price" DECIMAL(8, 2) NOT NULL,
    "quantity" BIGINT NOT NULL,
    PRIMARY KEY("id_product","id_sale")
);