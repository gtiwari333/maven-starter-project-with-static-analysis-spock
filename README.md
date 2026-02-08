# A maven 'starter' project with BATTERIES 🔋 included

## Included Plugins/Libraries:

### Static Code Analysis:

- spotbugs with findsecbugs and sb-contrib
- checkstyle
- modernizer
- error-prone

### Extra build, code generation tools and libraries 

- owasp dependency check
- git-commit-id
- jacoco
- failsafe and surefire plugins - for integration (`**IT.java`) and unit (`**Test.java`) tests
- FAT jar generation
- native image generation with GraalVM
- lombok
- dependency Mgmt with Spring Boot(though it's not a Spring Boot project) so that we don't need to include our own dependency version
- archunit for coding rules 
- spock for writing better Unit Tests. JUnit is also included

## How to Build

```bash
./mvnw clean package

# run jar file with
java -jar target/my-app.jar Bob 22
```

## Create native image with GraalVM

```bash 
# Install GraalVM (using SDKMAN)
sdk install java 25-graal

sdk use java 25-graal

# Build the native image (creates 14.7MB file in about 46 seconds), takes few milliseconds to execute
./mvnw native:build 

# create jar and build native together
#  ./mvnw clean package native:build 

The native executable will be created in target/my-native-app (or target/my-native-app.exe on Windows).

# run native image
./target/my-native-app  Bob 22

```

# Simple Benchmark

### Native Image

```bash
time ./target/my-native-app  Bob 22
```

``` 
real    0m0.004s
user    0m0.003s
sys     0m0.001s
```

### Jar

```bash
time java -jar target/my-app.jar Bob 22
```

``` 
real    0m0.088s
user    0m0.175s
sys     0m0.054s
```



## Code Quality

#### The `error-prone` runs at compile time.

#### The `modernizer` `checkstyle` and `spotbugs` plugin are run as part of maven

`test-compile` lifecycle phase. Owasp plugin can be run ad-hoc

### SonarQube scan

**Run sonarqube server using docker**

    docker run -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

**Perform scan:**

    ./mvnw sonar:sonar
    ./mvnw sonar:sonar -Dsonar.login=admin -Dsonar.password=admin

**View Reports in SonarQube web ui:**

- visit http://localhost:9000
- default login and password are `admin`, you will be asked to change password after logging in with default
  username/password
- (optional) change sonarqube admin password without logging in
- 
```bash
curl -u admin:admin -X POST "http://localhost:9000/api/users/change_password?login=admin&previousPassword=admin&password=NEW_PASSWORD"
```

- if you change the password, make sure the update `-Dsonar.password=admin` when you run sonarqube next time



## Run test

```bash 
# run tests only

./mvnw clean test 

# run test and jacoco report/check
./mvnw clean verify

```


### Running unit tests (`**Test.java, **Spec.groovy`) only (it uses maven surefire plugin)

    ./mvnw  compiler:testCompile resources:testResources  surefire:test

### Running integration tests (`**IT`) only (it uses maven-failsafe-plugin)

    ./mvnw  compiler:testCompile resources:testResources  failsafe:integration-test

## Dependency/plugin version checker

    ./mvnw versions:display-dependency-updates
    ./mvnw versions:display-plugin-updates

## Future plan:

- docker plugin
- add examples of a native CLI app, a lambda etc in separate branches

