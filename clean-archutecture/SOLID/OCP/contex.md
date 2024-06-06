# OCP (open close principle)
 - This step says the class is open to extend, but closed to change
 - Example, if I have a service class and my task is add a validation to a method inside there, this following this principle, I would create a second class with this validation and extend super class service. Inside this class, I would have a method to call super method, but with this validation.
