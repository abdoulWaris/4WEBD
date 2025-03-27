# 🎟️ Ticket System

# Spring Boot Microservices Project(E-Ticketing System)

This project consists of 8 microservices built using Spring Boot, Maven, PostgreSQL, MongoDB, Kafka and Zikkin. The microservices are:

1. **🛠️ Config Server**: Centralized configuration server for all microservices.
2. **🔍 Discovery Server**: Service registry that depends on the Config Server.
3. **🌐 API Gateway**: Gateway for routing requests to the appropriate microservice and also handle LoadBalancing.
4. **🎫 Product Service**: Manages ticket-related operations.
5. **📦 Order Service**: Handles order-related operations.
6. **📢 Notification Service**: Manages notifications, integrated with Thymeleaf,Kafka and Zookeeper.
7. **💳 Payment Service**: Handles payment-related operations.
8. **👥 Customer Service**: Manages customer-related operations.
9. **📂 Project structure**: You can see more about our project on 
```sh
https://app.diagrams.net/#HabdoulWaris%2F4WEBD%2Fmain%2FDiagrams%2Fmicro-services.drawio#%7B%22pageId%22%3A%22VbmSNMpitOyS2P8errUJ%22%7D.
```
## Microservices Overview

### 🛠️ Config Server
- Centralized configuration management for all microservices.
- Uses Spring Cloud Config.
- Configuration files can be stored in a Git repository, but we choose to store them locally in the configuration directory within the Config Server's resources.
- Runs on port 8888.
### 🔍 Discovery Server
- Service registry for all microservices.
- Depends on the Config Server for configuration.
- Uses Spring Cloud Netflix Eureka
- Runs on 8761 port.

### 🌐 API Gateway
- Routes requests to the appropriate microservice.
- Uses Spring Cloud Gateway
- Runs on Port 8222.

### 🎫 Product Service
- Manages product-related operations.
- Uses Spring Boot and PostgreSQL.
- Runs on 8050 port.
 
### 📦 Order Service
- Handles order-related operations.
- Uses Spring Boot and PostgreSQL.

### 📢 Notification Service
- Manages notifications.
- Integrated with Kafka and Zookeeper.
- Uses Spring Boot and MongoDB.
- Runs on 8040 port.

### 💳 Payment Service
- Handles payment-related operations.
- Uses Spring Boot and PostgreSQL.
- Runs on 8060 port.

### 👥 Customer Service
- Manages customer-related operations.
- Uses Spring Boot and SQL.
- Runs on 8090 port.

## Prerequisites

- ☕ Java 17
- 🐍 Maven 3.8.5
- 🐳 Docker
- 🦄 Kafka and Zookeeper (for Notification Service)
- 📈 ZIPKIN (for logs and monitoring)

## 🛠️ Building and Running

1. Clone the repository.
2. Make sure you have Docker installed and running.
3. Make sure you have ZIPKIN is running.

## Running the Microservices 

## use Docker

1. then run `docker-compose up -d` in the root directory.
2. then run each dockerfile in each microservice directory.

## use an IDE

1. Run `docker-compose up -d` in the root directory.
2. Run the Config Server, Discovery Server, other services, and finally the API Gateway (it's important to follow this order).

## Accessing the Services

 Access the services using the following URLs:
   - 🛠️ Config Server: http://localhost:8888
   - 🔍 Discovery Server: http://localhost:8761
   - 🌐 API Gateway: http://localhost:8222
   - 🎫 Product Service: http://localhost:8050
   - 📦 Order Service: http://localhost:8030
   - 📢 Notification Service: http://localhost:8040
   - 💳 Payment Service: http://localhost:8060
   - 👥 Customer Service: http://localhost:8090
   - 📈 ZIPKIN: http://localhost:9411

For example, to fetch all products: http://localhost:8222/api/v1/products
To fetch all customers or create a new one: http://localhost:8222/api/v1/customers
## Next Steps

1. **🔒 Add Security with Keycloak**: Integrate Keycloak for authentication and authorization.
2. **☸️ Kubernetes for Deployment**: Deploy the microservices on a Kubernetes cluster.
3. **🌐 Front Service with Angular**: Develop a front-end service using Angular.
4. **🐳 Finish Docker-Compose**: Complete the `docker-compose.yml` file for all services.
5. **🚀 Add CI/CD**: Implement Continuous Integration and Continuous Deployment using tools like Jenkins, GitHub Actions, or GitLab CI.
6. **🧪 Further Testing**: Write and execute comprehensive tests for all microservices.
7. **🔍 GraphQL**: Integrate GraphQL for efficient data querying.
8. **📈 Monitoring and Logging**: Implement monitoring and logging using Prometheus and Grafana.

## License

This project is licensed under the MIT License.





