# Procedures
 - Procedures is an method to save a sequence of commands and call then easily


``` SQL

-- MYSQL 
CREATE PROCEDURE SearchStudentByRegistration(IN studentRegistration VARCHAR(7))
	SELECT * FROM students where registration = studentRegistration;

```