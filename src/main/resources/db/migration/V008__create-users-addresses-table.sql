CREATE TABLE "users_addresses"(
    "id_user" UUID,
    "id_address" UUID,

    PRIMARY KEY ("id_user","id_address")
);