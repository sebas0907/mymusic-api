# Build stage
#FROM maven:3.6.3
#COPY . .
# Compile and package the application to an executable JAR
#ARG Port
#ARG Db
#ARG User
#ARG Pass
#RUN mvn -DPort=${Port} -DDb=${Db} -DUser=${User} -DPass=${Pass} clean package
#define base docker image
FROM openjdk
ARG JAR_FILE=music-0.0.1-SNAPSHOT.jar
#copy files to container directory
COPY target/${JAR_FILE} app.jar
#expose the port
EXPOSE 8080
#execute the app
ENTRYPOINT ["java","-jar","/app.jar"]
