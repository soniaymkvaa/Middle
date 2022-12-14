# Middle
# Our Site
Deployed on Heroku [here](https://stormy-meadow-76982.herokuapp.com/api/v1/company/ucu.edu.ua)
# Use Case Diagram
![image](https://user-images.githubusercontent.com/91615487/205441658-7bde3713-2c8a-490f-8919-e7fa5b3d0cbd.png)


Link to it is [here](https://drive.google.com/file/d/1sbqMWllOCk__RWYNQouIqdWPiZuVh0YC/view?usp=sharing)
# UML Diagram

![uml_diagram](https://user-images.githubusercontent.com/96056537/205756892-0c0c64b3-927c-4c80-8956-47752a4cfc5d.png)

Link to it is [here](https://raw.githubusercontent.com/soniaymkvaa/Middle/master/uml_diagram.png)
# Patterns used
Are described [here](https://github.com/soniaymkvaa/Middle/blob/master/patterns.txt) 

# How to use
To get info about some domain type ```https://stormy-meadow-76982.herokuapp.com/api/v1/company``` (for local host: ```http://localhost:8080/api/v1/company```) and add ```/domain```<br><br>
To get info about all domains that are already in database just type ```https://stormy-meadow-76982.herokuapp.com/api/v1/company``` for heroku and ```http://localhost:8080/api/v1/company``` for local host

Examples of get requests can be found in [test.http](https://github.com/soniaymkvaa/Middle/blob/master/test.http)
- for local host
![image](https://user-images.githubusercontent.com/91982071/205481550-4e847574-adb4-48c2-92ab-a283cb5e3c41.png)

- for heroku
![image](https://user-images.githubusercontent.com/91982071/205481576-059b6e3c-c312-46a7-9dd6-1d128c53034a.png)

# Examples
![image](https://user-images.githubusercontent.com/91982071/205482130-29e4d27a-f96a-4e7f-81d4-32b084150320.png)
![image](https://user-images.githubusercontent.com/91982071/205483162-77f9c0c4-6985-4fa4-bd2f-2b82413aef28.png)
![image](https://user-images.githubusercontent.com/91982071/205482148-0502920b-e032-4205-bd10-0bfb353fb4ef.png)
![image](https://user-images.githubusercontent.com/91982071/205482103-ed9bd1aa-209d-4f34-9acf-bc54956c00f4.png)

# Patterns we used:

In this midtherm project, we used such OOP patterns that helps us.
1) Proxy
It`s a structural design pattern that receives client requests, performs some work, and then passes the request to an object. it is useful when we want to add additional methods to an object of an existing class without changing the client code.
if briefly, we form a request that will then give an answer to the user (who wants to receive some information about the Company)

2) Builder
It`s a creational design pattern that allows you to construct objects step by step (it is especially useful when we have complex objects (an object with many configuration parameters)).
In short, when creating our output, we gradually create an instance of a class.
