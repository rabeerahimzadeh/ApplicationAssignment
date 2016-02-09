# Synopsis

The Company project provides REST API support in backend as well as a front end panel for demonestration and backend service interaction.  
Its architecture is based on Spring, Spring MVC and Hibernate in the back-end and AngularJS and Semantic-UI frameworks in front. The project web services are designed to: 
 
 * **_Add_** company
 * **_Update_** company
 * **_List_** available companies
 * **_Show_** details of companies

Also it is possible to **_add_**, **_update_** and **_list_** the **_Owner(s)_** of each company afterward which are stored in the data base. Meanwhile it supports **_adding_**, **_updating_** and **_listing_** **_Employee(s)_** as well.  

The datails of each company which is stored in database are:  

 * Company ID
 * Name
 * Address
 * City
 * Country
 * Email
 * Phone Number
 * Company Employee(s)
 * Company Owner(s)

The database is MYSQL DB and it consists of the following tables:

* company
* owner
* employee 
* employee_company
* owner_company


# Installation

 1. Clone the project from github  
 2. Build the project with maven: mvn clean install  
 3. Create schema name appassignment in mysql.  
 4. Configure the Database attributes of project from in this path: src\main\resources\persistence.properties  
 5. Run schema script from this path : src\main\resources\sql\schema.sql  
 6. Run initial table script from this path : src\main\resources\sql\initial-data.sql  
 7. Run the web application with application server like Apache tomcat.  

# API Reference

---

### _List of Companies_

  Returns json data about list of all companies.

* **URL**

  /company

* **Method:**

  `GET`
  
*  **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ [{"companyId":1,"name":"Johnson Corporation","address":"153 James Street","city":"Miami","country":"USA"
,"email":"Info@Johncorp.com","phoneNumber":"5554-777-9999"},{"companyId":2,"name":"ABC KH, Inc.","address"
:"1240 North Expressway","city":"Arizona","country":"USA","email":"info@abc.com","phoneNumber":"1234-123-1234"
}] }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -X GET http://54.149.53.172:8080/applicationAssignment/company

---

### _Details of a Company_

  Returns json data about details of a company.

* **URL**

  /company/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ {"companyId":1,"name":"Johnson Corporation","address":"153 James Street","city":"Miami","country":"USA"
,"email":"Info@Johncorp.com","phoneNumber":"5554-777-9999"} }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -X GET http://54.149.53.172:8080/applicationAssignment/company/1  
  
---

### _Update Details of a Company_

  Update details of a company.

* **URL**

  /company

* **Method:**

  `PUT`
  
*  **URL Params**

  None

* **Data Params**

   **Required:**
 
   `address=[String]`  
   `city=[String]`  
   `companyId=[integer]`  
   `country=[String]`  
   `email=[String]`  
   `name=[String]`  
   `phoneNumber=[String]`  

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ OK }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`
 
  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -H 'Content-Type: application/json' -H 'Accept: application/json' -X PUT -d '{"address":"153 James Street","city":"Miami","companyId":"1","country":"USA","email":"Info@Johncorp.com","name":"Johnson Corporation","phoneNumber":"5554-777-9999"}' http://54.149.53.172:8080/applicationAssignment/company

---

### _Add a Company_

  Add a new company.

* **URL**

  /company

* **Method:**

  `POST`
  
*  **URL Params**

  None

* **Data Params**

   **Required:**
 
   `address=[String]`  
   `city=[String]`   
   `country=[String]`  
   `email=[String]`  
   `name=[String]`  
   `phoneNumber=[String]`  

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ OK }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

 OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -H 'Content-Type: application/json' -H 'Accept: application/json' -X POST -d '{"address":"153 James Street","city":"Miami","country":"USA","email":"Info@Johncorp.com","name":"Johnson Corporation 2","phoneNumber":"5554-777-9999"}' http://54.149.53.172:8080/applicationAssignment/company

---

### _List of Employees_

  Returns json data about list of all employees.

* **URL**

  /company

* **Method:**

  `GET`
  
*  **URL Params**

  None

* **Data Params**

  **Required:**
 
  `companyId=[integer]`  

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ [{"employeeId":1,"firstName":"Alba","lastName":"Sarullo","selected":false},{"employeeId":2,"firstName"
:"Hiske","lastName":"Tusa","selected":false},{"employeeId":3,"firstName":"Hyun","lastName":"Walkup","selected"
:false},{"employeeId":4,"firstName":"Ignoria","lastName":"Wisnosky","selected":false},{"employeeId":5
,"firstName":"Mauson","lastName":"Zynda","selected":false},{"employeeId":6,"firstName":"Larkin","lastName"
:"Zotti","selected":false}] }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   ccurl -X GET http://54.149.53.172:8080/applicationAssignment/employee?companyId=3

---


### _Update Employees of a Company_

  Update Employees of the selected company

* **URL**

  /company

* **Method:**

  `PUT`
  
*  **URL Params**

  None

* **Data Params**

   **Required:**
 
   `companyId=[integer]`  
   `selection=[array of integers]`    

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ OK }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -H 'Content-Type: application/json' -H 'Accept: application/json' -X PUT -d '{"selection":[2,4],"companyId":3}' http://54.149.53.172:8080/applicationAssignment/employee	

---



### _List of Owners_

  Returns json data about list of owners of the company.

* **URL**

  /company

* **Method:**

  `GET`
  
*  **URL Params**

  None

* **Data Params**

  **Required:**
 
  `companyId=[integer]`  

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ [{"ownerId":1,"firstName":"John","lastName":"Haeger","selected":false},{"ownerId":2,"firstName":"Kruel"
,"lastName":"Junk","selected":false},{"ownerId":3,"firstName":"Krynicki","lastName":"Merone","selected"
:false},{"ownerId":4,"firstName":"Madere","lastName":"Wisnosky","selected":false},{"ownerId":5,"firstName"
:"Roswick","lastName":"Oxborrow","selected":false},{"ownerId":6,"firstName":"Selph","lastName":"Ozawa"
,"selected":false}] }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   ccurl -X GET http://54.149.53.172:8080/applicationAssignment/owner?companyId=1

---


### _Update Owners of a Company_

  Update owners of the selected company

* **URL**

  /company

* **Method:**

  `PUT`
  
*  **URL Params**

  None

* **Data Params**

   **Required:**
 
   `companyId=[integer]`  
   `selection=[array of integers]`    

* **Success Response:**

  * **Code:** 200  
    **Content:** `{ OK }`
 
* **Error Response:**

  * **Code:** 404
    **Content:** `{ NOT FOUND }`

  OR

  * **Code:** 500
    **Content:** `{ INTERNAL SERVER ERROR }`

  OR

  * **Code:** 417 
    **Content:** `{ APPLICATION INTERNAL EXCEPTION}`

* **Sample Call:**

   curl -H 'Content-Type: application/json' -H 'Accept: application/json' -X PUT -d '{"selection":[2,4],"companyId":3}' http://54.149.53.172:8080/applicationAssignment/owner	

---


# Considerations

### Security  
It is important that the resource/service providers apply a security mechanism in order to restrict un-authorized access to the services provided. To date, in distributed computing, there is a strong trend regarding securing web services.  

One protocol which is used nowadays widely for this purpose is **OAuth**.  The OAuth is a standard which provides authorization for resource owners, customers and server resource. It assigns an _access token_ to the client by the authorization server. This access token is used when the client invoke the service which is protected.  
 
Based on this [forum](http://www.beingjavaguys.com/2014/10/spring-security-oauth2-integration.html), it is recommended to secure _Company_ restful web services using **_Spring Security_** and **_OAuth2_**. The client sends a Get request for authenticating. Using the _Spring Security_ framework and after user credential check, _OAuth_ generates an _access token_ and send it back to the client. Whenever the client wants to access the services, it sends the request attaching the access token to the server. Therefor the server grant its access and reply the request as well.  

### Service Redundancy  

I suggest the following method/architecture for service redundancy.  

The first suggestion is maintaining service redundancy using **_Heroku Dynos_**. A _Dyno_ in _Heroku_ is a lightweight, virtualized Linux container in which _Heroku_ executes applications. So, it is possible to run multiple _Dynos_ which results in fault tolerance and redundancy mechanism. In this environment,   if one or more _Dynos_ fail, the job can continue its processing as well. It is recommended to run _Dynos_ in different physical infrastructure for higher redundancy.  

In addition, the service providers can take advantages of queue-based messaging. In this architecture, there are different replica servers (I call it as a server pool). A load balancer receives an incoming request from queue and then deliver it to a replica server which has higher available resource. The queue is used as a buffer between client and servers. Client sends request to a queue instead of directly sending to server.  Server sends reply to a queue instead of directly sending to client. Depending on the project requirements, this method is useful because client can send request even if server is down, busy or disconnected. Server also can send reply even if client is down. Also in this solution, workload balancing across many servers is fully dynamic.  

# Demo URL
http://54.149.53.172:8080/applicationAssignment/#/company


















