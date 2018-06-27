# Stock Viewer

Stock viewer application on Micro-services Architecture using Netflix OSS stack



Tech stack:

- Java 10
- Maven (build tool)

- Netflix OSS Stack
 - Zuul Proxy (gateway)
 - Eureka Client
 - Eureka Server

- Spring boot 2.0.1
- Spring cloud
- Postman
- UI: Angular js
- DB: MySQL
-YahooFinance API

Each modules is a deployable micro service

- `db-service` - For interactive with MySQL DB
- `stock-service` - For pulling Stock Price from YahooFinance API
- `eureka-service` - Service Registry for registering all micro services
- `zuul-gateway` - gateway service
- `ui` - Angular JS UI

## Architecture Diagram:
![Architecture](Architecture.png)
