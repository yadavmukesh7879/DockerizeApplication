FROM openjdk:17

LABEL mentainer="Mukesh Yadav"

WORKDIR /app

COPY target/restApi.jar /app/restApi.jar

ENTRYPOINT ["java", "-jar", "restApi.jar"]