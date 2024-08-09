# Spring-Config-Server

### Diagrams (Link)[https://drive.google.com/file/d/1JPuDmRJ0Hn4YmiVrhVV04cCjVGA0erFO/view?usp=sharing)

### Application Setup

- Java 17
- Spring Boot (3.3.x)
- H2 Database

### Remote Repository

- Create your remote repository on github to integrate with config-server. 
- Create an access token on github.
- Update the credentials in config-server by setting your github username and the access token generated.

### Image Docker RabbitMQ

- docker run -d -p 5672:5672 -p 15672:15672 --name=rabbitmq-2 rabbitmq:3.8.3-management

> Important: To work distribuited,  it's necessary to have an instance of rabbitMQ or another broker. (If you use another broker, it's necessary to update configuration on the config-server and your client's)

### OBS:
I plan to integrate with aws in the future :)
