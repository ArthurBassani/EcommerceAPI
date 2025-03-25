ALTER TABLE
    "shopping"
ADD CONSTRAINT
    "shopping_user_foreign"
FOREIGN KEY
    ("id_user")
REFERENCES
    "users"("id");