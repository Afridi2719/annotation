FROM openjdk:21
WORKDIR /AnotationsTesting-0.0.1-SNAPSHOT
COPY target/AnotationsTesting-0.0.1-SNAPSHOT.jar AnotationsTesting-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java","-jar","AnotationsTesting-0.0.1-SNAPSHOT.jar" ]
