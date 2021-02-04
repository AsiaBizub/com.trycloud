# com.trycloud

TRYCLOUD

Selenium-TestNG framework assignment

Description

In this assignment each group will create an automated testing framework for testing TryCloud
company’s application.
The framework will use : 
  Java
  Maven
  Selenium WebDriver
  TestNG
  Git/Github

Discuss the “git branching strategy” first, then implement it during the automation.

Conduct “Code Review” whenever is needed to explain any re-usable method to the team, or
go over PR.

Create one class for each user story.

Things to do:
One person from the team :

1. Set up the project in his/her environment while the other team members are watching
(Follow the next page)

2. Create local repo

3. Create a remote repository & add all the other team members as collaborators

The other team members :
1. Accept the GitHub invitation
2. Clone the repository

Project set up:

1. Create a Maven project.
            Group-id: com.trycloud
            Artifact-id: trycloudautomation

2. Add all the required dependencies for automation to the pom file.

3. Under src/test/java create following packages:
      a. com.trycloud.tests
      b. com.trycloud.tests.base
      c. com.trycloud.utilities
      
4. Under the project folder add file configuration.properties 
                            add file .gitignore

5. Under utilities package create:
      a. ConfigurationReader
      b. BrowserUtils
      c. WebDriverFactory
      
