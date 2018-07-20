# stateinfogenerator v1.0

# Introduction

Well come to stateinfogenerator Java Program. This is a program that Build a Library of All USA State By Parsing a Rest Get Request Response. See the Rest Web-service Response using url : http://services.groupkt.com/state/get/USA/all
Program will not start if rest server is down or return error.

Then The Program start taking input from a user and return information back as per the input information.

### Prerequisites

This is a simple maven project created to make the script CI/CD ( continuous integration ) friendly.
java & Maven need to be properly install on targeted nod to run this program.

### Installing & Executing the Program

* Clone the git-hub repo to any machine that has maven installed
* Open terminal in mac or CMD in windows
* CD to the project Directory
* run this below command to start the program
* mvn -q test

* or simply run this executable file below
* Mac [sh Run.sh]
* Windows [Run.bat]

## Running From Eclipse

* Also We can Clone the Repo in Eclipse
* Then Right click the POM.XML file and
* Select Run - > Run As maven Test

### Test Plan & Test Case

We Can Test the Program by using following Scenarios

```
TestCase ID	|	Test Data	|	Type |	Description
=======================================================================================
Test 0		 |	MD	|	Positive	|	Search State Information with 2 Character Upper Case abbreviation
Test 1		 |	md	|	Positive	|	Search State Information with 2 Character lower case abbreviation
Test 2		 |	nY	|	Positive	|	Search State Information with 2 Character Mix   case abbreviation
Test 3		 |	Maryland	|	Positive	|	Search State Information with full state name
Test 4		 |	xyz	|	negative	|	Search State Information with random name - It Should return invalid state






Note: Don’t change the format of the test case in .txt file. it’s a BDD friendly test case can be used in Cucumber framework

## Authors

* **MD Rasul**
```
