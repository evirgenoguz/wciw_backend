# define base docker image
FROM openjdk:11
ADD target/wciw-0.0.1-SNAPSHOT.jar wciw.jar
ENTRYPOINT ["java", "jar", "wciw.jar"]