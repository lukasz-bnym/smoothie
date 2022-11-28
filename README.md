# smoothie

### Prerequisites
- docker
- java 11

### Steps to run
- Run the below commands in terminal from root of project:
  - ./gradlew clean build
  - docker build -t smoothie-app:latest .
  - docker-compose up -d
- Now the application is running/listening on localhost:8080

### Exposed rest endpoints
- GET /smoothie
- GET /smoothie/{id}
- POST /smoothie
- PUT /smoothie/{id}
- DELETE /smoothie/{id}
- POST /order

Unfortunately, I did not manage to finish order endpoint. It just returns ACCEPTED status code. I had a plan to send a notification to a Kafka topic.

### Users
- END_USER
  - login: user
  - password: user_password
- BUSINESS_OWNER
  - login: owner
  - password: owner_password

The convenient way to test endpoints would be with Postman and for Authorization use Basic Auth
