# Rest Levels Maturity
 - Actually, we have 5 levels of maturity in REST API's
    1. <strong>Services by URI:</strong>
       - Each URI represents a service, like a RPC (Reomte Procedure Call)
    2. <strong>Resources by URI:</strong>
       - All services are in same URI, but to call then, you need to specify a request method (GET, POST, PUT DELETE...), example:
         - GET - to get a task -> https://my-endpoint/task
         - POST - to create a task -> https://my-endpoint/task 
         - PUT - to update a task -> https://my-endpoint/task 
         - DELETE - to delete a task -> https://my-endpoint/task 
    3. <strong>HTTP Verbs:</strong>
       - In this case, the HTTP methods is used in the correct way,  example
         - GET - to get a task -> https://my-endpoint/task
         - POST - to create a task -> https://my-endpoint/task 
         - PUT - to update a task -> https://my-endpoint/task/{taskId} 
         - DELETE - to delete a task -> https://my-endpoint/task/{taskId}
    4. <strong>HATEOAS:</strong>
       - This is more high level of maturity, in this level, the http responses have other endpoints to use, example:
         - If I have a endpoint to list details of smatphone, the example of API with third levelof maturity be like:
         ```json 
             {
                 "id": "dfaofnbaeoifgne",
                 "smartphone_name": "neres x plus",
                 "price": 2000.00
             }
         ```
         - If I have a API with fourth level of maturity, the response will be like:
        ```json 
             {
                 "id": "dfaofnbaeoifgne",
                 "smartphone_name": "neres x plus",
                 "price": 2000.00,
                   "links": [
                    {
                        "rel": "self",
                        "href": "https://api.minhaloja.com/produtos/dfaofnbaeoifgne"
                    },
                    {
                        "rel": "buy",
                        "href": "https://www.minhaloja.com/comprar/dfaofnbaeoifgne"
                    },
                    {
                        "rel": "similar",
                        "href": "https://api.minhaloja.com/produtos?categoria=smartphones"
                    }
                ]
             }
         ```
        
