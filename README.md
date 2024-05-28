# Bloomberg FX Deals Data Warehouse

## Project Description

This project is part of a scrum team effort to develop a data warehouse for 
Bloomberg to analyze foreign exchange (FX) deals.
One of the key customer stories involves accepting deal details and persisting them into a database for further analysis.

## Technologies Used

- **Java 17**
- **Spring Framework**
- **PostgreSQL Database**
- **Spring Data JPA**
- **H2 Database (for testing)**
- **JUnit (for testing)**

## How to Run the Project

To build and run the project, use the following command:
```sh
make all
  - `make all`
   ```
  - this will build maven and then run the docker compose file
## How to Run the Project
  - execute this request to create a new deal:
    ```
    curl --location 'http://localhost:8080/deal' \
    --header 'Content-Type: application/json' \
    --data '{
    "uniqueId": 1,
    "fromCurrencyIsoCode": "JOD",
    "toCurrencyIsoCode": "JOD",
    "dealTimestamp": "2024-05-27",
    "amount": 1000.00
    }'
    ```