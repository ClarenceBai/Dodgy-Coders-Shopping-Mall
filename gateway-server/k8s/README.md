## build docker image
mvn clean package
docker build . -t order-service:0.0.1
docker images -a | grep order-service

## load docker image
kind load docker-image order-service:0.0.1

## list docker images on a cluster node
docker exec -it kind-control-plane crictl images
docker exec -it kind-worker crictl images
docker exec -it kind-worker2 crictl images

## deploy application to kubernetes
kubectl apply -f order-service-deployment.yaml
kubectl get deployments

## use below command to check the app logs
## cheat sheet https://kubernetes.io/docs/reference/kubectl/cheatsheet/
kubectl logs -l app=order-service --tail=200

## scaling resources
kubectl scale --replicas=4 -f order-service-deployment.yaml

## testing in an app container
## https://kubernetes.io/docs/reference/generated/kubectl/kubectl-commands#exec
kubectl exec orderservice-deployment-bb47656b8-4mrhp -c order-service -it -- sh

## Discovering services https://kubernetes.io/docs/concepts/services-networking/service/#discovering-services
nc -v nginx 80