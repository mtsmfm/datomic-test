#! /usr/bin/env bash

set -e

sed "/host=0.0.0.0/a alt-host=${ALT_HOST}" -i transactor.properties
sed "s/# storage-admin-password=/storage-admin-password=${ADMIN_PASSWORD}/" -i transactor.properties
sed "s/# storage-datomic-password=/storage-datomic-password=${DATOMIC_PASSWORD}/" -i transactor.properties
sed "s|license-key=|license-key=${LICENSE_KEY}|" -i transactor.properties

bin/transactor transactor.properties &

bin/run start.clj

wait
