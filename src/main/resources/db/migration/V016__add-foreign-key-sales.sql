ALTER TABLE
    "sales"
ADD CONSTRAINT
    "sales_user_foreign"
FOREIGN KEY
    ("id_user")
REFERENCES
    "users"("id");

ALTER TABLE
    "sales"
ADD CONSTRAINT
    "sales_address_foreign"
FOREIGN KEY
    ("id_address")
REFERENCES
    "addresses"("id");
