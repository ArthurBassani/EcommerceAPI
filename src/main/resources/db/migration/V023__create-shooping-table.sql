CREATE TABLE "shopping"(
    "id" UUID PRIMARY KEY NOT NULL,
    "id_user" UUID NOT NULL,
    "date" TIMESTAMP(0) WITH TIME zone NOT NULL,
    "total_value" DECIMAL(8, 2) NOT NULL
);
