# DRY
 - DRY (Don't Repeat Yourself) is a principal that encourages the reuse of code, if I have two or more identical codes, I need to create a method to reuse it, creating a function for example.
 - Example:
  ``` javascript

  // violation
  function insertUser(user){
    if(user.email === null){
        throw new Error("email cannot be null");
    }
    dbUser.insert(user);
  }

  function insertAdmim(admin){
    if(user.email === null){
        throw new Error("email cannot be null");
    }
    dbAdmin.insert();
  }

  // solution
  function insertUser(user){
    validateData(user)
    dbUser.insert(user);
  }

  function insertAdmim(admin){
    validateData(admin)
    dbAdmin.insert();
  }

  function validateData(data){
    if(data.email == null){
        throw new Error("email cannot be null");
    }
  }
  
  ```