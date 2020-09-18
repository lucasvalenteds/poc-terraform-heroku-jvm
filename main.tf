variable "heroku_email" {
	type = string
}

variable "heroku_api_key" {
	type = string
}

variable "heroku_app_name" {
	type = string
}

variable "heroku_region" {
	type = string
	default = "us"
}

terraform {
	required_providers {
		heroku = {
			source = "heroku/heroku"
			version = "2.6.1"
		}
	}
}

provider "heroku" {
	email   = var.heroku_email
	api_key = var.heroku_api_key
}

resource "heroku_app" "server" {
	name   = var.heroku_app_name
	region = var.heroku_region

	config_vars = {
		GRADLE_TASK = "shadowJar"
	}
}

resource "heroku_build" "server" {
	app = heroku_app.server.name
	buildpacks = ["https://github.com/heroku/heroku-buildpack-gradle.git"]

	source = {
		path = "server/"
	}
}

resource "heroku_addon" "database" {
	app  = heroku_app.server.name
	plan = "heroku-redis:hobby-dev"
}

output "server_url" {
	value = "https://${heroku_app.server.name}.herokuapp.com"
}
