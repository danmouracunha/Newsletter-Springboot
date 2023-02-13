FROM maven:3.8.3-jdk-11  as build

ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME
COPY . .

RUN mvn clean package -DskipTests

FROM maven:3.8.3-jdk-11

ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

ARG RABBITMQ_SERVER=rabbitmq
ARG EUREKA_SERVER=eurekaserver

COPY ./target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar