# **My Java API Project**

## **Introduction**
I have created a budget planner API that intends to calculate the user's savings by subtracting the total expenses from the total income and revealing how much money they have left. My API then allows the user to select a percentage, to which I have added three alternatives: 10%, 15%, and 20%, to apply to their savings. It also recommends Lloyd's Bank's suggestion of the 50-30-20 rule, which is to spend 50% of your total income on needs, 30% on wants, and 20% on savings.


## Setup, installation and running for my API
To setup my API follow these instructions below:
1. Clone the repository: git clone https://github.com/miski19/budgetingplannerAPI.git

1. Navigate to the project directory in the terminal using GitBash: 
```sh
cd budgetingplannerAPI
```
1. Install the dependencies from the terminal using this command for MacOs:

```sh
./mvnw clean dependency:resolve
```
And using this command for Windows:
```cmd
mvnw clean dependency:resolve
```
4. Then run the API from the terminal using this command for MacOs:
```sh
./mvnw spring-boot:run
```
And using this command for Windows: 
```cmd
mvnw spring-boot:run
```
### **How my API works:**
You can test my API after you've cloned the respository, installed the dependancies and ran Spring Boot. These are instructions on how to test my api.
1. You have to open up Postman (or another REST client) and request body in JSON format for the `GET`,`PUT` and `POST` requests. 
My URL is: localhost:8080/api/budgetplanner


Insert this JSON as the body for Postman: 
```JSON
{
    "user": {
    "id": "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454",
    "name": "Miski Hassan",
    "email": "miski12@abc.com",
    "date": "2024-04-23T18:25:43.511Z",
    "userPercentage": 20
    },

   "income": [
        {
            "salaryAfterTaxesById": 10000.00,
            "selfEmploymentIncomeById": 400.00,
            "statutorySickPayById": 100.00,
            "statutoryMaternityPayById": 100.00,
            "frequency": "monthly"
        }
    ],
    "benefitsAndTaxCredits": [
        {
            "jobSeekersAllowanceById": 0.00,
            "workingTaxCreditById": 50.00,
            "childTaxCreditById": 30.00,
            "childBenefitById": 20.00,
            "employmentSupportAllowanceById": 40.00,
            "universalCreditById": 0.00,
            "disabilityAllowanceById": 0.00,
            "attendanceAllowanceById": 80.00,
            "carersAllowanceById": 90.00,
            "housingBenefitById": 110.00,
            "maternityAllowanceById": 130.00,
            "frequency": "monthly"
        }
    ],
    "otherIncome": [
        {
            "rentalIncomeById": 300.00,
            "investmentIncomeById": 200.00,
            "frequency": "monthly"
        }
    ],
    "pensions": [
        {
            "statePensionById": 200.00,
            "privatePensionById": 100.00,
            "frequency": "monthly"
        }
    ],
    "bills": [
        {
            "rentById": 1400.00,
            "mortgageById": 500.00,
            "mortgageEndowmentById": 600.00,
            "councilTaxById": 100.00,
            "insuranceById": 200.00,
            "utilitiesById": 800.00,
            "groceriesById": 400.00,
            "frequency": "monthly"
        }
    ],
    "leisure": [
        {
            "entertainmentById": 150.00,
            "diningOutById": 100.00,
            "travelById": 1500.00,
            "sportsMembershipById": 70.00,
            "frequency": "monthly"
        }
    ]
   
    }
```
   








    
    





