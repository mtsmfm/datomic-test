FROM openjdk:15-buster

ARG DATOMIC_VERSION=0.9.6024
ARG DATOMIC_HTTP_USER
ARG DATOMIC_HTTP_PASSWORD

RUN curl --user ${DATOMIC_HTTP_USER}:${DATOMIC_HTTP_PASSWORD} -L https://my.datomic.com/repo/com/datomic/datomic-pro/${DATOMIC_VERSION}/datomic-pro-${DATOMIC_VERSION}.zip > datomic.zip && \
  unzip datomic.zip && \
  mv datomic-pro-${DATOMIC_VERSION} /datomic && \
  rm datomic.zip

WORKDIR /datomic

RUN cp config/samples/dev-transactor-template.properties transactor.properties

RUN sed "s/host=localhost/host=0.0.0.0/" -i transactor.properties
RUN sed "s/# storage-access=local/storage-access=remote/" -i transactor.properties

RUN mkdir /data
RUN sed "s/# data-dir=data/data-dir=\/data/" -i transactor.properties

COPY entrypoint.sh .
COPY start.clj .

ENTRYPOINT ["./entrypoint.sh"]
