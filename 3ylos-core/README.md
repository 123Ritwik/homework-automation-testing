## Automation core

Testing and validation of REST services and selenium in Java.
This framework is developed using REST Assured,Cucumber,TestNg,selenium,selenide and maven.

API is the acronym for Application Programming Interface, which is a software intermediary that allows two applications
to talk to each other. REST Assured is a Java library that provides a domain-specific language (DSL) for writing
powerful, maintainable tests for RESTful APIs. Cucumber is an open source library, which supports behavior driven
development. To be more precise, Cucumber can be defined as a testing framework, driven by plain English text. It serves
as documentation, automated tests, and a development aid – all in one.

### **Rest API testing using Rest-Assured Java Framework**

- This is repository of basic REST API testing framework
- This framework is developed using **Rest-Assured** library for Rest API testing
- For JSON Parsing in java the library used is - **json-simple** and **Jackson API**
- Reporting is by **cucumber-reporting API**

### **Some of the key features of this framework:**

1. It generates Extent report with all the step details. Report will be generated both HTML & PDF file format.
2. Generates execution logs, with detailed request and response details.
3. Feature file has examples of reading request details from json and excel file.
4. This also has an example to validate response body using json schema and java pojo classes.
5. Test execution can be triggered form command line.
6. Easy integration to CI/CD pipeline.

### **Technologies/Tools used in building the framework :**

- Rest Assured
- TestNG
- Java
- Cucumber Reports
- Hamcrest
- Jackson API
- Lombok
- IntelliJ
- GitHub
- Jenkins

### **Framework implements below best practices**

- Scalable and extensible
- Reusable Rest Assured specifications
- Reusable Rest Assured API requests
- Separation of API layer from test layer
- POJOs for Serialization and Deserialization
- Singleton Design Pattern
- Lombok for reducing Boilerplate code
- Builder pattern for Setter methods in POJOs
- Robust reporting and logging using Allure
- Automate positive and negative scenarios
- Support parallel execution
- Data driven using TestNG Data Provider
- Automated access token renewal
- Maven command line execution
- Integration with Git
- Integration with Jenkins

## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test

Once the execution completes report & log will be generated in below folder.

**Report:**        *target/report*<br>
**Log:**        */logs*


