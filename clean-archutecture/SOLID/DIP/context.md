# DIP (Dependency Inversion Principal)
 - A high level class cant depend on a low level class, so, we have work with interfaces only, never with the concrete class.
 - If we have a service where inside there we need other services to run other methods, we have to create interfaces to other services class, and call this interfaces instead of concrete class