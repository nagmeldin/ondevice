## Micronaut 5.1.1 Documentation

- [User Guide](https://docs.micronaut.io/5.1.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/5.1.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/5.1.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://gradleup.com/shadow/)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
## Feature micronaut-aot documentation


- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature http-client documentation


- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#nettyHttpClient)


## Feature test-resources documentation


- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature jul-to-slf4j documentation


- [https://www.slf4j.org/legacy.html#jul-to-slf4jBridge](https://www.slf4j.org/legacy.html#jul-to-slf4jBridge)


## Feature liquibase documentation


- [Micronaut Liquibase Database Migration documentation](https://micronaut-projects.github.io/micronaut-liquibase/latest/guide/index.html)


- [https://www.liquibase.org/](https://www.liquibase.org/)


## Feature jakarta-data documentation


- [Micronaut Jakarta Data documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/#jakartaData)


- [https://jakarta.ee/specifications/data/1.0/jakarta-data-1.0](https://jakarta.ee/specifications/data/1.0/jakarta-data-1.0)


## Feature data-jdbc documentation


- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)


## Feature jdbc-hikari documentation


- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature serialization-jackson documentation


- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

## Endpoint testing:
http://localhost:8080/devices/

http://localhost:8080/ranks/

http://localhost:8080/devices/makes

http://localhost:8080/devices/models

http://localhost:8080/devices/list

http://localhost:8080/ranks/grades

http://localhost:8080/ranks/statuses

http://localhost:8080/points/

http://localhost:8080/points/xs

http://localhost:8080/points/ys

http://localhost:8080/points/distances

http://localhost:8080/points/closest

http://localhost:8080/locales/

http://localhost:8080/locales/cities

http://localhost:8080/locales/markets

##  CRUD Operation:

$ curl http://localhost:8080/devices/makes

$ curl -X POST http://localhost:8080/devices/add  -H "Content-Type: application/json" -d '{ "id": 7, "make":"arsta", "model":"7280R3", "os": "eos" , "year": 2023, "health": 2 }'

$ curl -X PUT http://localhost:8080/devices/1/update  -H "Content-Type: application/json" -d '{ "id": 1, "make":"CISCOx", "model":"XR250", "os": "iOS" , "year": 2021, "health": 3 }'

$ curl -i -X DELETE http://localhost:8080/devices/1


