FROM openjdk:11
WORKDIR "~/build/"
COPY . .
RUN ./mvnw clean install

FROM openjdk:11
COPY --from=0 "~/build/target/deploy-action.jar" .
COPY entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]
