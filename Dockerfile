FROM maven:3-openjdk-11-slim
WORKDIR /app
COPY . .
RUN mvn install

ARG PORT_arg=8080

#default port
ENV PORT ${PORT_arg}

EXPOSE ${PORT}
# we can use -p in run statement or EXPOSE in Dockerfile

ENTRYPOINT ["mvn","spring-boot:run"]

#docker network create mongo_network
#docker run --rm -d --network mongo_network --name mongo mongo
#docker build -t app:v3 .
#docker run --network mongo_network -p 3000:8080 --name app --rm -v volumes:/app/demo/files -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\demo:/app" app:v3

#http://localhost:3000/docker/logs
