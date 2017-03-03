# currencyExchange
## Description
Currency Exchange RESTful API built for Stylight application process. Used Yahoo to get exchange rates for every calculation.

## Running locally
- Git clone the repository.
- Run this inside the repository.
```bash
java -jar currencyExchange-1.0-RELEASE.jar
```

## Example Requests
- To convert from EUR to USD: `\exchange\1.00?from=EUR&to=USD
- Available currency identifiers:
  * USD
  * EUR
  * JPY

## Technology Stack
- SpringBoot 1.5.1
- Maven for Dependency management
