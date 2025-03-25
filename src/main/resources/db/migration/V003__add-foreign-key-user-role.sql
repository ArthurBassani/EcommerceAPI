ALTER TABLE
    "users"
ADD CONSTRAINT
    "users_role_foreign"
FOREIGN KEY
    ("id_role")
REFERENCES
    "roles"("id");
