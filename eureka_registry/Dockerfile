FROM maven:3-openjdk-11-slim
WORKDIR /app
COPY . .
RUN mvn install

ARG PORT=8010

ENV PORT ${PORT}

EXPOSE ${PORT}


ENTRYPOINT ["mvn","spring-boot:run"]
#docker run --rm --name eureka -p 3000:8010 -v "C:\Users\lenovo\Documents\workspace-spring-tool-suite-4-4.11.0.RELEASE\eureka_registry:/app" --network docker eureka