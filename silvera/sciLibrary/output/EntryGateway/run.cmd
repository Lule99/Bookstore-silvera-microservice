REM script for running the application

call mvn clean
@echo on

call mvn package
@echo on

java -jar --add-opens java.base/java.lang=ALL-UNNAMED target\EntryGateway-0.0.1-SNAPSHOT.jar --PORT=9191