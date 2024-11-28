FROM eclipse-temurin:21
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} learnlo-backend-1.0.0.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "learnlo-backend-1.0.0.jar"]