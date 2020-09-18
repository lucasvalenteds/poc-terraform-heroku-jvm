# POC: Terraform Heroku (JVM)

It demonstrates how to provision a JVM application and a Redis database at Heroku using Terraform.

The application should increment a counter persisted at Redis each time a HTTP request is received.

Both application and database should be deployed without manual actions. The only manual step needed is to put Heroku credentials in `Makefile` variables.

## How to run

| Description | Command |
| :--- | :--- |
| Provision | `make deploy` |
| Destroy | `make destroy` |
