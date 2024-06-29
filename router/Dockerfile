FROM maven:3-amazoncorretto-17 as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM amazoncorretto:17-alpine
COPY --from=build /home/app/target/gateway-router-1.0.3.jar /usr/local/lib/demo.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]