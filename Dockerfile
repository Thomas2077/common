FROM ubuntu:latest
LABEL authors="yanzou"

ENTRYPOINT ["top", "-b"]