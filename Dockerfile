FROM base-tesseract-ocr


WORKDIR /app

COPY ./target/ocr-test-0.0.1-SNAPSHOT.jar ./application.jar
COPY ./tessdata ./tessdata

EXPOSE 8080

CMD ["/bin/bash"]

ENTRYPOINT ["java", "-jar", "application.jar"]