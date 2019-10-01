FROM java:8


WORKDIR /app

COPY . /app

EXPOSE 8080
LABEL maintainer=“ahmedakrout58@gmail.com”

ADD ./target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]
