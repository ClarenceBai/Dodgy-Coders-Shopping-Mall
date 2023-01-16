#!/bin/bash

kind create cluster --config dodgycoder-kind-config.yaml

echo '================OUTPUT of kubectl cluster-info --context kind-kind=============='
kubectl cluster-info --context kind-kind
echo '================================================================================\n'

echo '================Loading application images==============\n'
kind load docker-image gateway-server:0.0.1
echo '================kind-control-plane images==============\n'
docker exec -it kind-control-plane crictl images | grep gateway-server
echo '================kind-worker images==============\n'
docker exec -it kind-worker crictl images | grep gateway-server
echo '================kind-worker2 images==============\n'
docker exec -it kind-worker2 crictl images | grep gateway-server

echo '================Deploying applications==============\n'
kubectl apply -f gateway-server-deployment.yaml
sleep 3

kubectl get deployments

kubectl logs -l app=gateway-server --tail=50

kubectl get deployments
kubectl get service

sleep 10
echo '================kubectl get pods -o wide==============\n'
kubectl get pods -o wide