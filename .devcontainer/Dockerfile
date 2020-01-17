FROM openjdk:15-buster

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

RUN apt-get update \
  && apt-get install -y zsh less autossh

ARG DATOMIC_VERSION=0.9.6024
ARG DATOMIC_HTTP_USER
ARG DATOMIC_HTTP_PASSWORD

RUN curl --user ${DATOMIC_HTTP_USER}:${DATOMIC_HTTP_PASSWORD} -L https://my.datomic.com/repo/com/datomic/datomic-pro/${DATOMIC_VERSION}/datomic-pro-${DATOMIC_VERSION}.zip > datomic.zip && \
  unzip datomic.zip && \
  mv datomic-pro-${DATOMIC_VERSION} /datomic && \
  rm datomic.zip

RUN useradd --create-home --user-group --uid 1000 app
RUN mkdir -p /app /original /datomic
RUN chown -R app /app /original /datomic

WORKDIR /app

USER app

ENV SHELL=/bin/zsh BUNDLE_PATH=/app/vendor/bundle HOME=/home/app
