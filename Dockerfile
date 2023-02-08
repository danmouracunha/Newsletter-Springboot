FROM maven:3.8.3-jdk-11

ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

COPY pom.xml $APP_HOME/pom.xml
COPY mvnw $APP_HOME/mvnw
COPY src $APP_HOME/src
COPY lib $APP_HOME/lib
RUN mkdir logs

RUN mvn clean package
