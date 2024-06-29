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
                                           
To `POST` it's `http://localhost:8080/(what you want to post)`

### Example
Insert this JSON as the body on Postman `POST` to create data for each entity class: 

User: `http://localhost:8080/user`

```json
{
    "name": "Miski Hassan",
    "email": "miski12@abc.com",
    "date": "2024-04-23T18:25:43.511Z",
    "userPercentage": 20
}
```
Income: `http://localhost:8080/income/{id}`

```json
 {
    "salaryAfterTaxesById": 10000.00,
    "selfEmploymentIncomeById": 400.00,
    "statutorySickPayById": 100.00,
    "statutoryMaternityPayById": 100.00,
    "frequency": "monthly"
}
```
Benefits and Tax Credits: `http://localhost:8080/benefitsAndTaxCredits/{id}`
```JSON 
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
 ```
 Other Income: `http://localhost:8080/otherincome/{id}`
```JSON 
{
   "rentalIncomeById": 300.00,
   "investmentIncomeById": 200.00,
   "frequency": "monthly"
}
```  
Pensions: `http://localhost:8080/pensions/{id}`
```JSON 
{

 "statePensionById": 200.00,
 "privatePensionById": 100.00,
  "frequency": "monthly"
}
 ```   

Bills:   `http://localhost:8080/bills/{id}`
```JSON 
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
 ```

Leisure:  `http://localhost:8080/leisure/{id}`
```JSON 
{
  "entertainmentById": 150.00,
  "diningOutById": 100.00,
  "travelById": 1500.00,
  "sportsMembershipById": 70.00,
  "frequency": "monthly"  
}

```
   
Once the data has been created for each entity, then...



Insert this JSON as the body on Postman `POST` to calculate savings based on % using this URL:`http://localhost:8080/budgetplanner/calculate-savings/{id}`
```json
{

  "id": "123e4567-e89b-12d3-a456-556642440000", // Replace with a valid UUID
  "totalIncome": 5000.00,
  "totalExpenses": 3000.00,
  "userPercentage": 15 


}

```
 Type this URL on Postman as a `GET` to see the sorted % (most popular to least popular):
  `http://localhost:8080/api/budgetplanner/sort/sortAllUsers` 


To this if the sorting works, type this URL as a `GET` request to test the quick sort algorithm: 
`http://localhost:8080/api/budgetplanner/user/sort-users-percentages`






    





