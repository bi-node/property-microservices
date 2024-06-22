docker run --name property-micro -p 5430:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=main_db -d
postgres:13

docker exec -it property-micro psql -U user -d main_db -c "CREATE DATABASE students;"

zipkin:
container_name: zipkin
image: openzipkin/zipkin
ports:
 -"9411:9411"
networks:
zipkin
