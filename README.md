# Spring Boot Microservice Assessment
There is 3 different projects<br>
To start please run the createDB.sql file. This will set up the database and put some test data in. 
### Eurake 
This is the naming server, simply run this one first to start
### Food
This is the Food Service. If in vscode it can be run using the launch.json file. You can add or change port options in the vmArgs option. 
### Customer
This is the Customer Service. If in vscode it can be run using the launch.json file. You can add or change port options in the vmArgs option. 

## Endpoints 
### Eurake 
`localhost:8761` <br>
Use this to view all microservices
### Food
`localhost:8000/getCustomer`<br>
This will return all customer from the database, using the customer service
`localhost:8000/getTopFood/1`<br>
This wil return the top 1, that is most bought. 
`localhost:8000/getTopFood/3`<br>
This wil return the top 3, that is most bought.  <br>
etc...
### Customer
`localhost:8000/getFood`<br>
This will return all food from the database, using the food service
`localhost:8000/getFoodBelow/11`<br>
This wil return all food below price 11, using the food service.
`localhost:8000/getFoodBelow/20`<br>
This wil return all food below price 20, using the food service. <br>
etc...