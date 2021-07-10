FROM maven:3-openjdk-11-slim
WORKDIR /app
COPY . .
RUN mvn install

ARG PORT=8011

ENV PORT ${PORT}

EXPOSE ${PORT}


ENTRYPOINT ["mvn","spring-boot:run"]

#docker run --name proxy --rm --network docker -p 3001:8011 -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\proxy-gate:/app" proxy
