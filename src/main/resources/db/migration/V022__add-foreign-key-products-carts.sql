ALTER TABLE
    "products_carts"
ADD CONSTRAINT
    "products_carts_product_foreign"
FOREIGN KEY
    ("id_product")
REFERENCES
    "products"("id");

ALTER TABLE
    "products_carts"
ADD CONSTRAINT
    "products_carts_cart_foreign"
FOREIGN KEY
    ("id_cart")
REFERENCES
    "carts"("id");