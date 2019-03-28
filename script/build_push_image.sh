#!/usr/bin/env bash
# build docker image
docker build -t knative-java-demo ../
docker tag knative-java-demo g4seek/knative-java-demo
# login before push
# docker login
docker push g4seek/knative-java-demo