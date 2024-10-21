# Use the official PostgreSQL image as the base image
FROM postgres:15

# Install PostGIS and its dependencies
RUN apt-get update && \
    apt-get install -y postgis postgresql-15-postgis-3 && \
    rm -rf /var/lib/apt/lists/*

# Ensure the PostGIS extension is available in the default database
# This step is optional and can be done manually after container startup
COPY ./init-database.sh /docker-entrypoint-initdb.d/
