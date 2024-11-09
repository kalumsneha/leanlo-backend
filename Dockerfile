FROM eclipse-temurin:21
WORKDIR /app
COPY target/learnlo-backend.jar learnlo-backend.jar
EXPOSE 8085
CMD ["java","-jar","learnlo-backend.jar"]