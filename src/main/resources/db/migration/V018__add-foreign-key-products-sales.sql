ALTER TABLE
    "products_sales"
ADD CONSTRAINT
    "products_sales_product_foreign"
FOREIGN KEY
    ("id_product")
REFERENCES
    "products"("id");

ALTER TABLE
    "products_sales"
ADD CONSTRAINT
    "products_sales_sale_foreign"
FOREIGN KEY
    ("id_sale")
REFERENCES
    "sales"("id");

