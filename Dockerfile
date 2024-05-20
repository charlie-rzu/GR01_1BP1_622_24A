FROM maven:3.8.5-openjdk-18-slim as build
COPY . /usr/GR01
WORKDIR /usr/GR01
RUN mvn clean install
RUN mvn package

FROM bitnami/tomcat:10.1.23 as server
COPY --from=build usr/GR01/target/tienda.war /opt/bitnami/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]