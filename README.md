# Microservice-Java-Spring-Boot


plemented Eureka Server for dynamic service registration and discovery.
Utilized Spring Cloud Config Server to manage centralized configurations across all services.
🔹 Diverse Data Management
Integrated multiple databases tailored to each service's needs:
MySQL for relational data.
MongoDB for document-oriented storage.
PostgreSQL for advanced relational features.
🔹 Inter-Service Communication
Leveraged OpenFeign clients to facilitate seamless and declarative RESTful communication between services.
🔹 Resilience & Fault Tolerance
Employed Resilience4j to implement:
Circuit Breakers: Preventing cascading failures by halting calls to unresponsive services.
Retries: Automatically re-attempting failed requests to handle transient issues.
Rate Limiters: Controlling the rate of requests to protect services from overload.
🔹 Security Measures
Secured APIs using Spring Security, incorporating JWT tokens for authentication and authorization.
