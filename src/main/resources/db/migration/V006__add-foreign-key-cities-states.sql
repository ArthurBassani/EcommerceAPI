ALTER TABLE
    "cities" ADD CONSTRAINT "cities_states_foreign" FOREIGN KEY("id_state") REFERENCES "states"("id");