FROM maven:3.8.3-jdk-11
ARG SERVICE_NAME

WORKDIR /app

COPY ../pom.xml ./
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve

COPY ./${SERVICE_NAME}/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
