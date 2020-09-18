# POC: Terraform Heroku (JVM)

It demonstrates how to provision a JVM application and a Redis database at Heroku using Terraform.

The application should increment a counter persisted at Redis each time a HTTP request is received.

Both application and database should be deployed without manual actions. The only manual step needed is to put Heroku credentials in `Makefile` variables.

## How to run

| Description | Command |
| :--- | :--- |
| Provision | `make provision` |
| Destroy | `make destroy` |

## Preview

```
$ make provision 

Initializing the backend...

Initializing provider plugins...
- Using previously-installed heroku/heroku v2.6.1

Terraform has been successfully initialized!

You may now begin working with Terraform. Try running "terraform plan" to see
any changes that are required for your infrastructure. All Terraform commands
should now work.

If you ever set or change modules or backend configuration for Terraform,
rerun this command to reinitialize your working directory. If you forget, other
commands will detect it and remind you to do so if necessary.
heroku_app.application: Creating...
heroku_app.application: Creation complete after 8s [id=poc-terraform-heroku-jvm]
heroku_addon.database: Creating...
heroku_build.application: Creating...
heroku_addon.database: Still creating... [10s elapsed]
heroku_build.application: Still creating... [10s elapsed]
heroku_addon.database: Still creating... [20s elapsed]
heroku_build.application: Still creating... [20s elapsed]
heroku_addon.database: Still creating... [30s elapsed]
heroku_build.application: Still creating... [30s elapsed]
heroku_addon.database: Creation complete after 37s [id=28971749-53a9-402e-b3c1-711e21dfbbf2]
heroku_build.application: Still creating... [40s elapsed]
heroku_build.application: Still creating... [50s elapsed]
heroku_build.application: Still creating... [1m0s elapsed]
heroku_build.application: Still creating... [1m10s elapsed]
heroku_build.application: Still creating... [1m20s elapsed]
heroku_build.application: Still creating... [1m30s elapsed]
heroku_build.application: Still creating... [1m40s elapsed]
heroku_build.application: Still creating... [1m50s elapsed]
heroku_build.application: Still creating... [2m0s elapsed]
heroku_build.application: Still creating... [2m10s elapsed]
heroku_build.application: Creation complete after 2m13s [id=ed094c84-527d-451e-ba2f-19536be64673]

Apply complete! Resources: 3 added, 0 changed, 0 destroyed.

Outputs:

application_url = https://poc-terraform-heroku-jvm.herokuapp.com
```

```
$ make destroy 

heroku_app.application: Refreshing state... [id=poc-terraform-heroku-jvm]
heroku_addon.database: Refreshing state... [id=28971749-53a9-402e-b3c1-711e21dfbbf2]
heroku_build.application: Refreshing state... [id=ed094c84-527d-451e-ba2f-19536be64673]
heroku_addon.database: Destroying... [id=28971749-53a9-402e-b3c1-711e21dfbbf2]
heroku_build.application: Destroying... [id=ed094c84-527d-451e-ba2f-19536be64673]
heroku_build.application: Destruction complete after 0s
heroku_addon.database: Destruction complete after 1s
heroku_app.application: Destroying... [id=poc-terraform-heroku-jvm]
heroku_app.application: Destruction complete after 0s

Destroy complete! Resources: 3 destroyed.
```
