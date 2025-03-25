ALTER TABLE
    "carts"
ADD CONSTRAINT
    "carts_user_foreign"
FOREIGN KEY
    ("id_user")
REFERENCES
    "users"("id");