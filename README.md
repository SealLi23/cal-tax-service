# cal-tax-service
The project is microservice coming with RESTful APIs. The purpose is to calculate the congestion tax for the vehicle
according to the recorded timestamp during the travel. 

How to build?
1. Please ensure that Java 11 was installed in the environment correctly
2. Please confirm that Apache Maven was installed and configured correctly in your environment.
3. Open a CLI terminal and enter the root directory of the project.
4. Execute the bellowing command:
    <project_root_dir>#/ mvn clean package

How to launch it?
After build it,
1. Start up using java command
   <project_root_dir>#/ java -jar target/<jar_name>.jar
2. Build a docker image 
   <project_root_dir>#/ docker build  -t <custom_name>/<custom_example-app> ./
   and then start a container with it.
   <project_root_dir>#/ docker run -p 8080:8080 <custom_name>/<custom_example-app>

TODO: The current implementation is not mature, so there are several important enhancements to do.
1. to finalize the business logic and solution as mentioned in the questions.md
2. to enhance the validation on the request parameters
3. to add more testcases to improve its quality and maturity
4. to implement a module which can help dynamically calculate the holiday of a given year
5. to implement authentication and authorization and other security mechanisms