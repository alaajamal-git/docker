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

#docker run --name app --rm --env PORT=8000 -v volumes:/app/demo/files app:v2
#docker run --name app --rm -v volumes:/app/demo/files -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\demo:/app" --env-file ./.env app:v2
