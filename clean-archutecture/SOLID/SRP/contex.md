# SRP (Single Responsability Principal)
 - The class must have only one responsability
 - Example:
   - If I have a service class (in springboot) named ProcessRequestService, and inside it, I have 3 methods.
     - processRequest(): void
     - insertDatabase: void
     - sendEmail(): void
   - The problem is many methods inside this service class, de correct way to fix it, is create a class named DatabaseRepository, where this class will have a method to insert this data in database, next, is necessary to create a other class named EmailService, where it will have a method to sendEmail.
