## Технологии

- Java 8
- Spring Boot 2.7.18
- Maven
- PostgreSQL 14

## Запуск

### Полностью через Docker-контейнеры

```bash
docker compose up -d
```

### БД в Docker-контейнере, приложение локально

```bash
$ docker compose -f docker-compose.local.yml up -d
$ mvn package
$ java -jar ./target/library-online-0.0.1.jar
```

### Swagger

Доступен по [ссылке](http://localhost:8080/swagger-ui/index.html).
