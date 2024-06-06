# Celan code
 - Here, I will put some tips about how to write clean code.

## Functions
 - Functions must be short
 - Each function must do only 1 think (reference to Single Responsability Principal)
 - Conditional blocks must be short too. The "if/else", "try/catch", loops, must have only 1 line
 - Abstraction level: dont use conditionals inside other conditionals
 - Good names to functions (simple and intuitive)
 - Command/Consult split
 - Is a good pattern to create functions to treat the error in catch example
    ```javascript
    function insertUserName(username){
        try{
            db.insert(username)
        }catch(e){
            logError(e)
        } 
    }
    function logError(e){
        // implementation
    }
     ```
  - Dont repeat same code (try to not repeat yourself)

### Params
 - Boolean parameters indicates that your function is doing more think and need to avoid that
 - How many parameters my function must have? the ideal is 0
 - If you need to send 2 or more parameters, you cant send a object to this function