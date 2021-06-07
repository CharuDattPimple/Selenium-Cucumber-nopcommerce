# Selenium-Cucumber-nopcommerce

# Tools and technology used : 

Language: Java 

Version : 1.8

Testing framework: Cucumber

Automation tool: Selenium webdriver

Build tool: maven

Logging: log4j

Reporting: cucumber reporting






# Folder Structure

<img width="286" alt="structure" src="https://user-images.githubusercontent.com/26453207/121072358-bc495b00-c7ee-11eb-9fd0-79f8d55e7bb8.png">

# Reporting

running "mvn clean test" will generate the Cucumber report file target/cucumber.json

running "mvn verify -DskipTests" will generate the cucumber-report-html based on the cucumber.json

running "mvn clean verify" will do all together

<img width="1617" alt="CucumberReport1" src="https://user-images.githubusercontent.com/26453207/121072324-b3f12000-c7ee-11eb-9201-e3ca649fcc0d.png">
<img width="1640" alt="CucumberReport2" src="https://user-images.githubusercontent.com/26453207/121072346-b8b5d400-c7ee-11eb-9500-7ccc37808fcb.png">
<img width="1629" alt="CucumberReport3" src="https://user-images.githubusercontent.com/26453207/121072352-bb182e00-c7ee-11eb-970f-93ae7b9470f6.png">


