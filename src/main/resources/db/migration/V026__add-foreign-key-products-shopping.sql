ALTER TABLE
    "products_shopping"
ADD CONSTRAINT
    "products_shopping_product_foreign"
FOREIGN KEY
    ("id_product")
REFERENCES
    "products"("id");

ALTER TABLE
    "products_shopping"
ADD CONSTRAINT
    "products_shopping_shop_foreign"
FOREIGN KEY
    ("id_shop")
REFERENCES
    "shopping"("id");
