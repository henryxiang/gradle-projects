# Fiscal Certification Util Library

## Run a Specific Groovy App in Dev Mode

```bash
./gradlew runApp -PmainClass=fiscal.cert.App
```

To run the default application, which specified by `mainClassName` variable in `build.gradle` file,
use the following command

```bash
./gradlew run
```

## Build JAR file

```bash
./gradlew build
```

The fat-jar file will be built and put into `build/lib` directory.

## Run Java Class in JVM

```bash
java -cp build/lib/fiscal-cert.jar <full.class.Name>
```

To run the default class,

```bash
java -jar build/lib/fiscal-cert.jar
```
