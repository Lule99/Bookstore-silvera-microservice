# Bookstore-silvera-microservice

Demo Implementation of a distributed system based on microservices for publishing scientific papers developed with silvera as a part of a phd research.  
[Silvera](https://alensuljkanovic.github.io/silvera/) is a tool for accelerating the development of microservice architectures, which is developed as a
part of PhD research.  
The system contains the following microservices: User, SciPaper, and Library.  
User microservice allows users to register and log in. When registering, a user provides a username
(ID), password (mandatory), first name (mandatory), last name (mandatory), and email (optional). In
order to log in, the user must provide a username and password.  
SciPaper microservice allows logged-in users to write new scientific papers. Each paper has an author,
a title, and an arbitrary number of sections. Each section has its name and content. This microservice
has a special method, publish, which, for a given paper ID, publishes a PUBLISH_PAPER message to
a message broker. The message contains the paper’s ID, paper’s title, and author.  
Library microservice has a method that listens to the PUBLISH_PAPER message and keeps data
provided via message in the database. This microservice also has a public method that lists all data
from the database.
