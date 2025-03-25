CREATE TABLE "products_favorites"(
    "id_favorite" UUID NOT NULL,
    "id_product" UUID NOT NULL,
    PRIMARY KEY("id_favorite","id_product")
);