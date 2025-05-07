# Microservice-Java-Spring-Boot

🚀 Microservices Architecture with Java & Spring Boot
A robust and modular microservices-based system built using Spring Boot and Spring Cloud, focusing on scalability, resilience, and maintainability.

🔗 Service Discovery & Centralized Configuration
Implemented Eureka Server for dynamic service registration and discovery.

Utilized Spring Cloud Config Server to manage centralized and version-controlled configurations across all microservices.

🗃️ Polyglot Persistence
Each microservice uses a database tailored to its domain:

MySQL – for structured relational data.

MongoDB – for flexible, document-based storage.

PostgreSQL – for advanced relational operations and data integrity.

🔁 Inter-Service Communication
Leveraged OpenFeign clients for declarative RESTful communication between services — enabling clear and maintainable HTTP calls without boilerplate code.

💪 Resilience & Fault Tolerance
Integrated Resilience4j to enhance system reliability:

Circuit Breakers – prevent cascading failures from slow or unresponsive services.

Retries – automatically re-attempt transient failures.

Rate Limiters – control traffic and protect services from overload.

🔐 Security
Secured APIs with Spring Security and JWT (JSON Web Tokens) for stateless authentication and authorization.
