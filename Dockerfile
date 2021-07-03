FROM openjdk:8-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} shopmall.jar
ENTRYPOINT ["java", "-jar", "shopmall.jar"]