bash
#!/bin/bash
set -e

# Create the PostGIS extension in the default database
psql --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE EXTENSION IF NOT EXISTS postgis;
EOSQL
