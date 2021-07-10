FROM maven:3-openjdk-11-slim
WORKDIR /app
COPY . .
RUN mvn install



ENTRYPOINT ["mvn","spring-boot:run"]

#docker run --name service1 --rm --network docker -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\service1:/app" -p 3002:8080 service1