#FROM eclipse-temurin:21
#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} learnlo-backend-1.0.0.jar
#EXPOSE 8085
#ENTRYPOINT ["java", "-jar", "learnlo-backend-1.0.0.jar"]



# Start with a base image containing Java runtime
FROM eclipse-temurin:21

# Add Maintainer Info
LABEL maintainer="kalumsneha@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8085

# The application's jar file
ARG JAR_FILE=target/learnlo-backend-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} learnlo-backend-1.0.0.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/learnlo-backend-1.0.0.jar"]