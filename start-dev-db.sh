#!/usr/bin/env bash
docker run -dit --restart always --name tcrs-db -e MYSQL_ROOT_PASSWORD=tcrs -p 13306:3306 mysql:5.7.20
