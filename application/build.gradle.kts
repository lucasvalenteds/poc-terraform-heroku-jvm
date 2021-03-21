plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.helidon.webserver", "helidon-webserver", "2.0.2")
    implementation("io.lettuce", "lettuce-core", "5.3.3.RELEASE")
}

configure<ApplicationPluginConvention> {
    mainClassName = "com.example.Main"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
