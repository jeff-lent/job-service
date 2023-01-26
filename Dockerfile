
FROM openjdk:17
LABEL developer="waqar seth"
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
ADD ./createJob-0.0.1-SNAPSHOT.jar create-job-springboot-docker.jar
ENTRYPOINT ["java","-jar","create-job-springboot-docker.jar"]