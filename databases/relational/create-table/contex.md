# Create table
 - Create table is used to create a new tabe in database, see the code below
 ``` sql
    CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Age int,
    Address varchar(255),
    City varchar(255)
);
 ```
 - The fisrt param inside parentheses is the name of column in table and de second is the type of it.
 - Tip: We can create a table from an select in other tables example:
``` sql
CREATE TABLE PERSONS_ONLY_FIRST_NAME_AND_LAST_NAME_OF_LEVGAL_AGE AS
    SELECT LastName, FirstName,
    FROM Persons
    where Age > 18

```