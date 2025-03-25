ALTER TABLE
    "products_favorites"
ADD CONSTRAINT
    "products_favorites_product_foreign"
FOREIGN KEY
    ("id_product")
REFERENCES
    "products"("id");

ALTER TABLE
    "products_favorites"
ADD CONSTRAINT
    "products_favorites_favorite_foreign"
FOREIGN KEY
    ("id_favorite")
REFERENCES
    "favorites"("id");