## Bootiful CAS-enabled Kotlin web application

This is the simplest CASyfied Kotlin Spring Boot application that there could be. It uses [cas client auto config support](https://github.com/Unicon/cas-client-autoconfig-support)

It could be used as a template to build more complex Kotlin CAS-enabled Spring Boot apps, or simply as a quick tester for various CAS servers installations.

### To get started

* Make sure you have Java 8 installed (it won't work on Java versions less than 8)

* Clone this repository

* Change 3 required URL properties in `src/main/resources/application.yml` pointing to the desired CAS server and client host. For example:

  ```yaml
  cas:
    #Required properties
    server-url-prefix: https://localhost:8143/cas
    server-login-url: https://localhost:8143/cas/login
    client-host-url: https://localhost:8443
  ```

* Change SSL settings in `src/main/resources/application.yml` pointing to your local keystore and truststore. For example:
 
 ```yaml
 server:
   port: 8443
   ssl:
     enabled: true
     key-store: /Users/dima767/.keystore
     key-store-password: changeit     
 ```
 
  > Note: you also might need to do the self-cert generation/importing dance into the JVM's trustore for this CAS client/server SSL handshake to 
  work properly. 

* From the command line run: `./run`

* Visit `https://localhost:8443` in the web browser of choice and enjoy the CASyfied Kotlin Spring Boot app! 