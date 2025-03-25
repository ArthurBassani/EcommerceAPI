ALTER TABLE
    "favorites"
ADD CONSTRAINT
    "favorites_user_foreign"
FOREIGN KEY
    ("id_user")
REFERENCES
    "users"("id");
