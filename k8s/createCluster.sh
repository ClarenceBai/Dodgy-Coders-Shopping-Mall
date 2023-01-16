#!/bin/bash

kind create cluster --config dodgycoder-kind-config.yaml

# if statement reference: https://www.geeksforgeeks.org/bash-scripting-if-statement/
if [ $? != 0 ]; then
    echo "segs"
    # print error to stderr: https://riptutorial.com/bash/example/19824/print-error-messages-to-stderr
    echo "Error starting kind cluster. Exit now." >> /dev/stderr
    exit 1
fi

echo '================OUTPUT of kubectl cluster-info --context kind-kind=============='
kubectl cluster-info --context kind-kind
echo '================================================================================\n'

echo '================Deploy Metric Server=============='
kubectl apply -f metric-service-config.yaml

echo '*****************Now setting ingress***************\n'

echo '================Getting Nginx-ingress from remote==============\n'
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml

echo '================Sleep 20 seconds==============\n'
sleep 20

echo '================Checking ingress namespace pods==============\n'
kubectl get pods --namespace=ingress-nginx

echo '================Deploy Applications=============='
bash deployServices.sh
echo '================Deploy Applications Finished=============='