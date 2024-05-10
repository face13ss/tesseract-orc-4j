FROM ubuntu:latest@sha256:3f85b7caad41a95462cf5b787d8a04604c8262cdcdf9a472b8c52ef83375fe15

LABEL authors="dungla"


RUN apt update -y && apt install tesseract-ocr -y && apt install openjdk-17-jre -y

CMD ["/bin/bash"]