# A maven 'starter' project with several static analysis plugins integrated

## Included Plugins:
- spotbugs with findsecbugs and sb-contrib
- checkstyle
- modernizer
- error-prone
- owasp dependency check

- git-commit-id
- jacoco
- failsafe and surefire

## Code Quality

#### The `error-prone` runs at compile time.
#### The `modernizer` `checkstyle` and `spotbugs` plugin are run as part of maven `test-compile` lifecycle phase. Owasp plugin can be run ad-hoc



### SonarQube scan

Run sonarqube server using docker

    docker run -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

Perform scan:

    ./mvnw sonar:sonar
    ./mvnw sonar:sonar -Dsonar.login=admin -Dsonar.password=admin

View Reports in SonarQube web ui:

- visit http://localhost:9000
- default login and password are `admin`, you will be asked to change password after logging in with default
  username/password
- (optional) change sonarqube admin password without logging
  in: `curl -u admin:admin -X POST "http://localhost:9000/api/users/change_password?login=admin&previousPassword=admin&password=NEW_PASSWORD"`
- if you change the password, make sure the update `-Dsonar.password=admin` when you run sonarqube next time


#### Running unit tests only (it uses maven surefire plugin)

    ./mvnw  compiler:testCompile resources:testResources  surefire:test
#### Running integration tests only (it uses maven-failsafe-plugin)

    ./mvnw  compiler:testCompile resources:testResources  failsafe:integration-test


### Dependency/plugin version checker

    ./mvnw versions:display-dependency-updates
    ./mvnw versions:display-plugin-updates

## Future plan:

- configure graalvm native plugin
- docker plugin
- add examples of a native CLI app, a lambda etc in separate branches

