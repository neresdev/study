# Queries
 - Queries is the heart of databases, because any action to show, or modify any data, we use queries to do it.
 - Example, we need to pick up car names of people with id 1
  ``` sql
  SELECT CAR_NAME FROM PEOPLE_CARS pc
  inner join PEOPLE p on
  pc.PEOPLE_ID = p.PEOPLE_ID
  where p.PEOPLE_ID = 1
  ```