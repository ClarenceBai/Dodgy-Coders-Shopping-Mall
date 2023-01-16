#!/bin/bash

echo '================Building packages==============\n'
mvn -f ../user-service/client/pom.xml install -DskipTests &
mvn -f ../payment-service/clientApi/pom.xml install -DskipTests &
mvn -f ../order-service/client/pom.xml install -DskipTests &
wait
mvn -f ../pom.xml package -DskipTests -pl gateway-server &
mvn -f ../pom.xml package -DskipTests -pl goods-service &
mvn -f ../pom.xml package -DskipTests -pl order-service &
mvn -f ../pom.xml package -DskipTests -pl payment-service &
mvn -f ../pom.xml package -DskipTests -pl user-service &
wait

echo '================Building docker images==============\n'
docker build ../gateway-server/ -t gateway-server:0.0.1 &
docker build ../goods-service/ -t goods-service:0.0.1 &
docker build ../user-service/ -t user-service:0.0.1 &
docker build ../payment-service/ -t payment-service:0.0.1 &
docker build ../order-service/ -t order-service:0.0.1 &
wait
docker images -a | grep -service

echo '================Loading docker images==============\n'
kind load docker-image gateway-server:0.0.1 &
kind load docker-image goods-service:0.0.1 &
kind load docker-image user-service:0.0.1 &
kind load docker-image payment-service:0.0.1 &
kind load docker-image order-service:0.0.1 &

echo '================Deploying applications==============\n'
kubectl apply -f ../gateway-server/k8s/gateway-server-deployment.yaml
kubectl apply -f user-service-deployment.yaml
kubectl apply -f ../goods-service/k8s/goods-service-deployment.yaml
kubectl apply -f payment-service-deployment.yaml
kubectl apply -f order-service-deployment.yaml


echo '================List services==============\n'
kubectl get service
echo '================List Deployments==============\n'
kubectl get deployments

echo '================Sleep 60 seconds==============\n'
sleep 60

echo '================Creating ingress==============\n'
kubectl create ingress gatewayserver-localhost --class=nginx \
  --rule="localhost/*=gateway-server:9000"

echo '================Port Forward==============\n'
kubectl port-forward --namespace=ingress-nginx service/ingress-nginx-controller 9000:80
# echo '================Checking logs (order-service)==============\n'
# kubectl logs -l app=order-service --tail=20\

