ALTER TABLE
    "users_addresses" ADD CONSTRAINT "users_addresses_user_foreign" FOREIGN KEY("id_user")
    REFERENCES "users"("id");

ALTER TABLE
    "users_addresses" ADD CONSTRAINT "users_addresses_address_foreign" FOREIGN KEY("id_address")
    REFERENCES "addresses"("id");
