# Gradle Projects

## Initializing a Groovy/Java Application

```bash
mkdir demo-app
cd demo-app
gradle init --project-name demo-app --type groovy-application --package com.demo --dsl groovy
./gradlew run
```

## Showing Result for Each Test

Add the following content to `build.gradle` file:

```groovy
test {
    //we want display the following test events
    testLogging {
        events "PASSED", "STARTED", "FAILED", "SKIPPED"
    }
}
```

Then run tests with `./gradlew clean test` command.

## Building a All-In-One Uber JAR File

Add the `shadow` plugin to enable `gradle build` to create a uber jar:

```
plugins {
    ...

    id 'com.github.johnrengelman.shadow' version '4.0.3'

    ...
}
```

## Running a Application by Specifying Class Name

Add the following content to `build.gradle` file:

```groovy
// Enabling to run app by its class name
task runApp(type: JavaExec) {
    classpath = sourceSets.main.runtimeClasspath
    main = project.hasProperty('mainClass') ? project.getProperty('mainClass') : mainClassName
}
```

To run a specific application with its class name:

```bash
./gradlew runApp -PmainClass=com.demo.JavaApp
```
