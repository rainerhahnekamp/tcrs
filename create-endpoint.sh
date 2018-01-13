#!/usr/bin/env bash

docker run --rm \
  -u `id -u $USER` \
  -v $PWD:/local \
  swaggerapi/swagger-codegen-cli generate \
    -i /local/swagger.yaml \
    -c /local/swagger-cli-config.json \
    -l spring \
    -o /local/modules/endpoint

docker run --rm \
  -u `id -u $USER` \
  -v $PWD:/local \
  swaggerapi/swagger-codegen-cli generate \
    -i /local/swagger.yaml \
    -l typescript-angular \
    -o /local/ng-endpoints
