# mobilele
Spring example
MobiLeLeLe web application
MobiLeLeLe is an application in which you register cars, with several properties.
You will have to create a simple application which has several pages and some object entities.

1.	Data
This is the data layer of the application. There are some data object for you to implement.


Brand
Create a Brand class, which holds the following properties:
•	id – a uuid or number.
•	name – a name of brand.
•	created – a date and time.
•	modified – a date and time. 	


Model
Create a Model class, which holds the following properties:
•	id – uuid or number.
•	name – a model name.
•	category – an enumeration (Car, Buss, Truck, Motorcycle)
•	imageUrl – the url of image with size between 8 and 512 characters. 
•	startYear – a number.
•	endYear – a number. 
•	created – a date and time.
•	modified – a date and time. 
•	brand – a model brand. 





Offer
Create a Model class, which holds the following properties:
•	id – uuid or number.
•	description – some text.
•	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID). 
•	imageUrl – the url of image.
•	mileage – a number. 
•	price – the price of the offer. 
•	transmission – enumerated value (MANUAL, AUTOMATIC). 
•	year – the year of offered car. 
•	created – a date and time.
•	modified – a date and time. 
•	model – the model of a car. 
•	seller – a user that sells the car. 


User
Create a User class, which holds the following properties:
•	id – uuid or number.
•	username –  username of the user.
•	firstName –  first name of the user.
•	lastName –  last name of the user.
•	isActive – true OR false.
•	role –  user's role (User or Admin).
•	imageUrl – a url of user's picture.
•	created – a date and time.
•	modified – a date and time. 

UserRole
Create a UserRole class, which holds the following properties:
•	id – uuid or number.
•	role –  enumerated value.


2.	Populate DB
•	You will be given some cars data, that you must populate the database with. Create Data Initializer class, that reads information about cars from file and store it in the database when application starts for the first time.
Hint:
 
3.	Prepare All needed layers
•	Repositories 
o	If you want, you can implement some common methods
•	Services and their implementations
o	If you want, you can implement some common methods in implementations
•	ServiceModels, that contains the same fields as the entity

In the next Lab, we continue working on this application
