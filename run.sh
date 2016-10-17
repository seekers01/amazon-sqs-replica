#!/usr/bin/env bash

./mvnw clean package
java -jar target/amazon-sqs-1.0-SNAPSHOT.jar