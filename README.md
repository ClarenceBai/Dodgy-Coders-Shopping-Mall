# Dodgy Coder

## Introduction
The system is an online shopping website that allows users to log in and search for goods, then submit orders and pay for them. It's a distributed system that consists of five micro-services including a gateway server,  goods service, order service, payment service, and user service.
The business is extremely simplified as the focus of the project is distribution features. The functional features are listed below.  
- Gateway server: distributes the requests to corresponding microservices.
- Goods service: provides an API that returns all goods available, and another API that returns a goods by id.
- Order service: provides an API for submitting orders of multiple goods, meanwhile initiating payment using payment service.
- Payment service: provides a payment API for submitting payments for orders. It also verifies a user using user service.
- User service: provides a login API that verifies the username and password.
- Kubernetes (k8s): orchestrates docker-containerized services to run on a cluster of hosts.

## Compile and Run
### Prerequisites
#### To run the project:  
- Docker: [Docker Desktop](https://www.docker.com/) should be installed on your computer.
- kind: kind is a tool for running local Kubernetes clusters using Docker container “nodes”. It can be installed via [this guide](https://kind.sigs.k8s.io/).
- Java 8: the project requires Java 8.  
#### Testing purpose:
- k9s: K9s is a terminal based UI to interact with your Kubernetes clusters. It can be installed by following [this documentation](https://k9scli.io/) .
- Apache JMeter: It is designed to load test functional behavior and measure performance. You can download and run it by following [the official documentation](https://jmeter.apache.org/index.html).

### How to run?
▶ Start Docker Desktop on your computer  
▶︎ Pull the code to local  
▶ cd to the directory called 'k8s' under the project root folder  
▶ Open terminal and run the script named 'createCluster.sh' using command:
```
./createCluster.sh
```
The script will automatically create Kubernetes cluster, pods for each service, and other essential components for you.  
▶ If the script is executed successfully, the entry port of the application will be forwarded to http://localhost:9000, then you can use Postman or Jmeter to make requests to APIs, e.g., if we visit http://localhost:9000/api/goods, a full list of goods will be returned.  
▶ To re-deploy services, we can run this script using:
```
./redeployServices.sh
```
And all services will be removed and re-deployed in Kubernetes.  
▶ To delete the whole cluster, there is also a script available:
```
./deleteCluster.sh
```

## Link to the Report
[Group Report](./Dodgy%20Coder%20Group%20Report.pdf) is uploaded in the root folder of the project.

The report is also available at this link:
https://drive.google.com/file/d/1sfiRRHQquRF-4DAEqztDPQUXX_H6JryV/view?usp=sharing

## Link to the Video
The video has been uploaded as a sharing-only video to Youtube:  
https://www.youtube.com/watch?v=1aJmW-9utyk&ab_channel=WendiSong
