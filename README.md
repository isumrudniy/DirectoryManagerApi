To start docker container for the DB:
docker run --name postgres-db-rusoft -p 5432:5432 -e POSTGRES_USER=rusoft -e POSTGRES_PASSWORD=rusoftDB -e POSTGRES_DB=rusoftdb -d postgres.
