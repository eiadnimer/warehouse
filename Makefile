# Define the Makefile targets

# Target to build the project using Maven
build:
	mvn clean install

# Target to run Docker Compose
up: build
	docker-compose up

# Target to stop Docker Compose
down:
	docker-compose down

# Target to clean up Docker Compose containers, networks, and volumes
clean: down
	docker-compose rm -f -v

# Target to run the build and Docker Compose up in one command
all: up
