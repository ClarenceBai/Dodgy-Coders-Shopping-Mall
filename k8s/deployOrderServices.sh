#!/bin/bash

kubectl delete -f order-service-deployment.yaml

echo '================Building packages==============\n'
mvn -f ../order-service/client/pom.xml install -DskipTests
mvn -f ../pom.xml package -DskipTests -pl order-service

echo '================Building docker images==============\n'
docker build ../order-service/ -t order-service:0.0.1
docker images -a | grep -service

echo '================Loading docker images==============\n'
kind load docker-image order-service:0.0.1

echo '================Deploying applications==============\n'
kubectl apply -f order-service-deployment.yaml

echo '================List services==============\n'
kubectl get service
echo '================List Deployments==============\n'
kubectl get deployments

echo '================Sleep 10 seconds==============\n'
sleep 3
echo '================List Deployments==============\n'
kubectl get deployments

# echo '================Checking logs (order-service)==============\n'
# kubectl logs -l app=order-service --tail=20