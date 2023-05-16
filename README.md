# spring-boot-docker-template

##
mvn clean package

##
docker build --pull --rm -f "Dockerfile" -t docker-spring:latest "."

##
docker run --rm -it -p 8888:8888/tcp docker-spring:latest

"terminal.integrated.env.linux": {
        "telegram.token":"XXX:XXX",
        "telegram.username":"XXX_bot",
        "spring.datasource.url":"jdbc:postgresql://ep-XXX-XXX.neon.tech/DBNAME",
        "spring.datasource.username":"XXX",
        "spring.datasource.password":"XXX"
    }
