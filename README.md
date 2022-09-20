# expenseApp

FIRST WE WILL CREATE A MODEL/ENTITY CLASS, THEN GIVE ENTRIES IN DATABASE AFTER CONNECTING MYSQL AND SPRING-BOOT.

> so first we need to download spring initializer with required dependencies and import into eclipse/intellij.

> connect spring application to mysql database by writing essential code in "application.properties" file.

> creat the class "Expense" and give all details which needed to pass in database for each expense such as 
  "ID of the expense", "Description of Expense", "Amount of Expense", and the "Expense name itself".

  In order to do this, we just need to declare ID, Descrition, amount, expense with datatypes and keep them private.

  To access the private variables we need to create getters and setters, which need not be done manually, we can use annotations:

     @Getters ( import lambok.getters and lambok.setters)
     @Setters
     
     @Table(name="tbl_expense")   // though we have table name in mysql, if we want to give diffrent name "tbl_expense", we use this annotation.      

     @Id -> as ID is primary key

     @GeneratedValue(strategy=GenerationType.IDENTITY)

> Next, go to mysql workbench and create database "expenseapp", as we have already given table name in spring as "tbl_expense",
  the columns : expense, description,amount and id will be reflecting there in the workbench.

   SELECT * FROM expenseapp.tbl_expenses;
   USE tbl_expenses;
   
   INSERT INTO tb_expense(expense, description, amount)
   VALUES("room rent", "monthly rent for room", 7000.00);

   // similarly insert whatever you want....

   so we have made entries in database, and hence the model class creation is completed in spring.


NOW , WE NEED TO CREATE REPOSITORY, SERVICE AND CONTROLLER CLASS
------------------------------------------------------------------------------------------------------------------------------
> Under "repository" package create an interface "ExpenseRepository which is extended by JpaRepository interface<classname, primarykey datatype)

so repository is successfully created !! ...

> Under "service" package, create an interface "ExpenseService" and a class "ExpenseServiceImpl" which implements the interface "ExpenseService"..

    In "ExpenseService" interface create findAll() method of type list<Expense>

> Under "ExpenseServiceImpl" class, first Autowire the expense repository as below:
    
                          @Autowired
                          ExpenseRepository expenseRepository;

  Then override the the findAll() method and provide its implementation as follows:
  
                    public List<Expense> findAll(){

                            return expenseRepository.findAll();
                    }

> Next , is the controller:


  Inside "controller" package,, create a class "ExpenseController" with annotation @RestController

  then Autowire the expense Service as follows: 

          @Autowired
          ExpenseService expenseService
   
  then perform CURD operations by giving request mappings such as @GetMapping("/expense") or @PutMapping or @PostMapping or @DeleteMapping
  
  
  -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    OPTIONAL FOR ME : (FRONT-END)
  

  
  install all angular stuff 


ng new expense-app-frontstore

so open this angular project in visual studio code

Go to src, then to app , create three folders in app : "components", "models", "services" to store the respective classes

First,

under models create "expense.ts" file -- how?? -- in cmd -- ng g class models/expense --skipTests
 
similarly under services                       -- in cmd -- ng g s services/expense

similarly under componenents                   -- in cmd -- ng g c components/ListExpenses     -- so the html, css and ts componetns will be created
                                                                                                  and app-list-expenses selector will be created in .ts file


>> now in expense.ts file 
    
   export class Expense{
    
      "id":number; "expense":string; "amount":number; "description" : string;

   }


>> now we need to set the routes which can be done in app.module.ts

   so we need to set httpmodule inside route module -- that is becuae angular made a http client module inorder to make requests.

   so we will add import as --   import {HttpClientModule} from "@angular/common/http"

   then under imports in app.module.ts add: HttpClientModule

>> now under services go to :  expense.service.ts

   In the ExpenseServer constructor , we need to inject the http client inorder to make a get() request

   so within constructor , we give HttpClient as parameter that is private, and we code in order to return http client get request.
   
   and we will create a variable "getUrl" to store the link:  "http://localhost:8080/expenses";

>> now under: components.ts
   
    this gets the list of expenses 

>>now : componenet.html

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
