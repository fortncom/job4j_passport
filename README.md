### Passport

[![Build Status](https://app.travis-ci.com/fortncom/job4j_passport.svg?branch=master)](https://app.travis-ci.com/fortncom/job4j_passport)

This service automates the work of the passport office. 

##### Dependencies

* Spring Boot 2
* Java 14
* Maven
* Liquibase
* Travis CI
* Checkstyle

##### Provides REST API endpoints:

GET: /mfc/passport/

GET: /mfc/passport/id

GET: /mfc/passport?series

GET: /mfc/passport/expire

GET: /mfc/passport/soon_expire_date

POST: /mfc/passport/ + body with Passport

PUT: /mfc/passport/ + body with Passport

DELETE: /mfc/passport/{id}