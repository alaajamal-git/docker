FROM maven:3-openjdk-11-slim
WORKDIR /app
COPY . .
RUN mvn install
ENTRYPOINT ["mvn","spring-boot:run"]

#docker run --name app -d --rm -p 3000:8080 -v volumes:/app/files -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\demo:/app" app:v1