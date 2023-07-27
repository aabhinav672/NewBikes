### Identify New Bikes




## Project Description

The objective of this project is to develop a web automation script that performs several tasks on the zigwheels.com website. The script will open the website zigwheels.com and search for new bikes hover over it using action class and then will select upcoming bikes,In the upcoming bikes page again it will select Manufacturer as Honda from the dropdown retrieve Bike details whose price is less than 4 lakhs and print it, Now it will again go back to the website home and search for used cars hover over it using action class and select chennai. Then it will search for popular models and print it. Again it will navigate to home page and search for login/signup button and click on it then it will select google and click on it also then will provide with wrong email id and print the error message.

The project will be implemented using a web automation framework, such as Selenium, and will follow the steps outlined below:

### Objectives


## 1.Open Zigwheels.com:

	1. Open the Zigwheels.com website.
	

## 2.Retrieve Bikes details whose manufacturer is Honda:

	1. Search for new bikes and hover over it.
	2. Click on Upcoming bikes.
	3. Search for manufacturer and select Honda from dropdown.
	4. print the details as bike name price and launch date of Honda bikes whose price is below 4 Lakhs.


## 3.Retrieve popular models of used cars in Chennai:

	1. Navigate to zigwheels.com.
	2. Search for used cars and hover over it.
	3. Click on chennai.
	4. Search for Popular Models and print them.
	

## 4.Print error message by logging in with wrong email:

	1. Navigate back to zigwheels.com..
	2. Search for Login/Signup button and click on it.
	3. Search for google and click on it.
	4. Enter the wrong email id and click on next.
	5. Capture the error message and print it.



The project will provide an automated solution to perform these tasks efficiently, saving time and effort for the user. It aims to streamline the process of retrieving Bike details, Car details and Error message on Zigwheels.com website.

### The project is organized into 3 packages:

*Base*: Contains the following classes:
   		1. DriverSetup
   		
*Pages*: Contains the following classes:
   		1. ChennaiUsedCars 
    	2. HomePage
    	3. HondaDetails
   		4. LoginPage   		
   		
*Test*: Contains the following class:
   		1. AllTest
   		2. SmokeTest

