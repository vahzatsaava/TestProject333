# Read Me First
Test project for Store 
1)runn application with idea or java in your local machine,
2)

then open postman and try to add this link http://localhost:8056/api/v1/desktops/add
with method post and add this json object in body - 

{
"serialNumber": "ABCssss",
"manufacturer": "HP",
"price": 799.99,
"quantity": 3,
"formFactor": "desktop"
}


3) then try to change serialNumber if you want to add another model

4) after open this link in browser jdbc:h2:mem:testdb

5) add username=tony ,password=password 

6) in SQL statement:try to execute select * from product

7) and you see some values in table product
