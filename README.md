- descrption about the project buismess
- java version 17
- technology stack (spring, postegres, spring data, h2, junit)
- how to run
  - `make all`
  - this will build maven and then run the docker compose file
- how to use
  - execute this request
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