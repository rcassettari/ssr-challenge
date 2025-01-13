FROM wiremock/wiremock:3.10.0

WORKDIR /home/wiremock

COPY mappings /home/wiremock/mappings

EXPOSE 8082

CMD ["--port", "8082", "--root-dir", "/home/wiremock"]

