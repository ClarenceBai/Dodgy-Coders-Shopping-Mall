#!/bin/bash

echo '================Deleting applications==============\n'
kubectl delete -f ../gateway-server/k8s/gateway-server-deployment.yaml
kubectl delete -f ../goods-service/k8s/goods-service-deployment.yaml
kubectl delete -f user-service-deployment.yaml
kubectl delete -f payment-service-deployment.yaml
kubectl delete -f order-service-deployment.yaml

echo '================Deploy services===============\n'
bash deployServices.sh