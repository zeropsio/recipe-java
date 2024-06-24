# Zerops x Java
This is a basic example of a Java Spring Boot app running on [Zerops](https://zerops.io) — a simple endpoint with connect, read and write operations to a Zerops PostgreSQL database.

![java](https://github.com/zeropsio/recipe-shared-assets/blob/main/covers/svg/cover-java.svg)

<br />

## Deploy on Zerops
You can either click the deploy button to deploy directly on Zerops, or manually copy the [import yaml](https://github.com/zeropsio/recipe-java/blob/main/zerops-project-import.yml) to the import dialog in the Zerops app.

[![Deploy on Zerops](https://github.com/zeropsio/recipe-shared-assets/blob/main/deploy-button/green/deploy-button.svg)](https://app.zerops.io/recipe/java)

<br/>

## Recipe features
- Java 17 Spring Boot app running on a load balanced **Zerops Java** service
- Zerops **PostgreSQL 16** service as database
- Healthcheck setup example
- Utilization of Zerops' built-in **environment variables** system
- Utilization of Zerops' built-in **log management**

<br/>

## Production vs. development
The base of the recipe is ready for production, with the main differences being:

- Use a highly available version of the PostgreSQL database (change `mode` from `NON_HA` to `HA` in recipe YAML, `db` service section)
- Use at least two containers for the Java service to achieve high reliability and resilience (add `minContainers: 2` in recipe YAML, `api` service section)

Further considerations for running more complex, highly available Java production apps on Zerops:
- Containers are volatile - use Zerops object storage to store your files
- Use Zerops Redis (KeyDB) for caching, storing sessions and pub/sub messaging
- Implement more advanced logging, such as using [SLF4J](http://www.slf4j.org/) with [Logback](http://logback.qos.ch/)

<br/>

## Changes made over the default installation
- Configure the application to [listen on all network interfaces](https://github.com/zeropsio/recipe-java/blob/main/src/main/resources/application.properties#L11) (`server.address=0.0.0.0`) to ensure it's accessible within the Zerops environment

<br/>
<br/>

Need help setting your project up? Join [Zerops Discord community](https://discord.com/invite/WDvCZ54).
