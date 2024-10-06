FROM gradle:latest AS BUILD
WORKDIR /usr/app/back2reality
COPY . .
RUN gradle build


FROM openjdk:17-oracle
ENV JAR_NAME=back2reality-latest.jar
ENV APP_HOME=/usr/app/back2reality
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME
